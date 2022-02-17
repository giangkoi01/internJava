package busassignmentmanagement.service;

import busassignmentmanagement.Main;
import busassignmentmanagement.dao.RouterDAO;
import busassignmentmanagement.model.Router;

public class RouterService {
	public static RouterDAO routerDAO = new RouterDAO();
	
	public void showRouter() {
		Main.routers.forEach(e -> System.out.println(e));

	}

	public void addNewRouter() {
		Router router = new Router();
		router.input();
		Main.routers.add(router);
		routerDAO.insertRouter(router);
	}
	
	public static Router findRouterById(int routerId) {
		for (Router router : Main.routers) {
			if(router.getId() == routerId) {
				return router;
			}
		}
		return null;
	}
}
