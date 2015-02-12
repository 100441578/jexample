package com.dev118.jexample.spring.data.jpa;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class HibernateInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -6449127958221680244L;

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		// TODO Auto-generated method stub
		return super.onPrepareStatement(sql);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.onSave(entity, id, state, propertyNames, types);
	}

	
	
}
