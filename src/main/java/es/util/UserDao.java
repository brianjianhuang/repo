package es.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

public class UserDao {

	public static final String ES_INDEX = "test";
	TransportClient transportClient;

	public UserDao() throws UnknownHostException {
		transportClient = TransportClient.builder().build().addTransportAddress(
				new InetSocketTransportAddress(InetAddress.getByName("cib9l2002.svr.us.jpmchase.net"), 9300));
	}

	public void save(User user) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException,
			InvocationTargetException, IOException {
		String type = EsUtil.getType(user);
		String id = EsUtil.getId(user);

		if (type != null && id != null) {
			transportClient.prepareIndex(ES_INDEX, type, id).setSource(EsUtil.getSource(user)).execute().actionGet();
		} else {
			throw new IllegalArgumentException("The object doesn't have annotations or ID is null");
		}
	}

	public User findUserById(String id)
			throws IllegalArgumentException, IllegalAccessException, IOException, InvocationTargetException {

		GetResponse response = transportClient.prepareGet(ES_INDEX, EsUtil.getType(User.class), id).execute()
				.actionGet();

		return EsUtil.getObject(response, User.class);
	}

	public List<UserView> findUserViewByName(String name)
			throws IllegalArgumentException, IllegalAccessException, IOException, InvocationTargetException {

		SearchResponse response = transportClient.prepareSearch(ES_INDEX).setTypes(EsUtil.getType(User.class))
				.setQuery(QueryBuilders.matchQuery("name", name)) // Query
				.setFrom(0).setSize(60).setExplain(true).execute().actionGet();

		return EsUtil.getObjects(response, UserView.class);
	}
	
}
