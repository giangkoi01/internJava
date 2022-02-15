package busassignmentmanagement.service;

import busassignmentmanagement.Main;
import busassignmentmanagement.model.Router;
import busassignmentmanagement.util.file.FileUtil;

public class RouterService {
	public static FileUtil fileUtil = new FileUtil();
	
	public void showRouter() {
		Main.routers.forEach(e -> System.out.println(e));

	}

	public void addNewRouter() {
		Router router = new Router();
		router.input();
		Main.routers.add(router);
		fileUtil.writeDataToFile(Main.routers, "router.dat");
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
