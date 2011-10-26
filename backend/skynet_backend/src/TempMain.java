
import toctep.skynet.backend.dal.dao.DAOFacade;
import toctep.skynet.backend.dal.dao.UserDAO;
import toctep.skynet.backend.dal.dao.impl.mysql.DAOFacadeImpl;
import toctep.skynet.backend.dal.domain.User;

public class TempMain {
	
	public static void main(String[] args) {
		DAOFacade daoFacade = new DAOFacadeImpl();
		UserDAO daoUser = daoFacade.getUserDAO();
		daoUser.insertUser(new User("testname2"));
	}
	
}
