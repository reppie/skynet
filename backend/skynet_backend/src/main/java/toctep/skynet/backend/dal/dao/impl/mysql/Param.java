package toctep.skynet.backend.dal.dao.impl.mysql;

public class Param {
	
	private Object value;
	private int type;
	
	public Param(Object value, int type) {
		this.value = value;
		this.type = type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public int getType() {
		return type;
	}
	
}
