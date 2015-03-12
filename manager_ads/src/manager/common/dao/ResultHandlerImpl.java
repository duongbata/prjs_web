package manager.common.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class ResultHandlerImpl<K,V> implements ResultHandler {
	private Map<K, V> inMap = new HashMap<K, V>();
	
	private String key;
	
	private String value;
	
	public ResultHandlerImpl(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleResult(ResultContext rc) {
		Map<K, V> m = (Map<K, V>) rc.getResultObject();
		inMap.put((K)getFromMap(m, this.key), (V)getFromMap(m, this.value));
	}
	
	private Object getFromMap(Map<K, V> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}else if(map.containsKey(key.toLowerCase())) {
			return map.get(key.toLowerCase());
		} else {
			return map.get(key.toUpperCase());
		}
	}
	
	public Map<K, V> getInMap() {
		return inMap;
	}
}
