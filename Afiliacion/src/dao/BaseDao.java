/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utilerias.HibernateUtil;

/**
 * @author JoseLuisE
 *
 */
public class BaseDao<T extends Serializable> implements AutoCloseable {
	private Class<T> clazz = null;

	private Session session = null;

	private Transaction transaction = null;

	public BaseDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	
	public void save(T entity) {
		try {
			begin();
			session.save(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}
	
	public void saveList(List<T> entityList) {
		try {
			begin();
			for(T entity: entityList) {
				session.save(entity);
				transaction.commit();
			}
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}

	public List<T> read() {
		validateClazz();
		return session.createQuery("SELECT * FROM Student", clazz).getResultList();
	}

	public T read(Long primaryKey) {
		validateClazz();
		return (T) session.find(clazz, primaryKey);
	}

	public void update(T entity) {
		try {
			begin();
			session.merge(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}

	public void delete(T entity) {
		try {
			begin();
			session.remove(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}

	private void begin() {
		validateClazz();
		transaction = session.beginTransaction();
	}

	private void validateClazz() {
		if (clazz == null) {
			throw new IllegalArgumentException("No se obtuvo la clase");
		}
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void close() throws Exception {
		if (session.isOpen() == true)
			session.close();
	}

}