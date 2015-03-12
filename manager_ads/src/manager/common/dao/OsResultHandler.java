package manager.common.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class OsResultHandler implements ResultHandler{
	private Map<Integer, String> inMap = new HashMap<Integer,String>();
	
	@Override
	public void handleResult(ResultContext rc) {
		Map<Integer, String> m = (Map<Integer, String>) rc.getResultObject();
		inMap.put((Integer)getFromMap(m, "os"), (String)getFromMap(m, "value"));
	}
	
	private Object getFromMap(Map<Integer, String> map, String key) {
	    if (map.containsKey(key.toLowerCase())) {
	      return map.get(key.toLowerCase());
	    } else {
	      return map.get(key.toUpperCase());
	    }
	  }
	
	public Map<Integer, String> getInMap() {
		return inMap;
	}
}
