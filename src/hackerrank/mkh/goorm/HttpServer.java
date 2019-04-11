package hackerrank.mkh.goorm;

import java.util.HashMap;
import java.util.Map;

public class HttpServer {
	static Users users = new Users();
	private static final Map<Integer, String> code;
    static
    {
    	code = new HashMap<Integer, String>();
    	code.put(200, "OK");
    	code.put(201, "CREATED");
    	code.put(403, "FORBIDDEN");
    	code.put(404, "NOT_FOUND");
    	code.put(405, "METHOD_NOT_ALLOWED");
    }
    
	public static void main(String[] args) {
        String[] request = {"POST /users/CONY",
        					"POST /users/BROWN",
        					"POST /users/CONY/data value=WHERE_IS_SALLY",
        					"GET /users/CONY/data",
        					"GET /users/BROWN/data",
        					"GET /users/EDWARD/data",
        					"GET /abc",
        					"GET /users/CONY"
        					};

		
        for(int i=0; i<request.length; i++) {
        	String[] sArr = request[i].split(" ");
        	
        	if(sArr[0].equals("POST")) postProc(sArr);
        	else getProc(sArr);      	
        }
	}
	
	public static void postProc(String[] arr) {
		int result = 200;
		
		String[] ids = arr[1].split("/");
		if(arr.length == 2) result = users.setUser(ids[2]);
		else				result = users.putData(ids[2], arr[2].substring(6));
		
		System.out.println(result + " "+ code.get(result));
	}
	
	public static void getProc(String[] arr) {
		int result = 200;

		String[] ids = arr[1].split("/");
		if(ids.length <= 2) result = 404;
		else if (ids.length <= 3) result = 405;
		else {
			String data = users.getData(ids[2]);
			
			if(data == null)          result = 403;
			else if (data.equals("")) result = 404;	
			
			if(result == 200) System.out.println(200 + " " + code.get(result) + " " + data);
		}
		 
		if(result != 200) System.out.println(result + " "+ code.get(result));
	}
}

class Users {
	Map<String, String> users = new HashMap<>();
	
	public int setUser(String user) {
		String result = users.putIfAbsent(user, "");
		
		if(result != null) return 403; 
		return 201;
	}
	
	public int putData(String user, String data) {
		String result = users.put(user, data);
		
		if(result != null) return 200;
		else return 403;
	}
	
	public String getData(String user) {
		return users.get(user);
	}
}
