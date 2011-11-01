package toctep.skynet.backend.dal.dao.impl.mysql;

public class Param {
	public Object value;
	public int type;
	public Param(Object value, int type) {
		this.value = value;
		this.type = type;
	}
}
