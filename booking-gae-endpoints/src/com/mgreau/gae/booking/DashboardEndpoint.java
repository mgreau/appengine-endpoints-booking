package com.mgreau.gae.booking;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(name = "bookingendpoint", clientIds = { Ids.CLIENT_ID }, audiences = { Ids.AUDIENCE })
public class DashboardEndpoint {

	@SuppressWarnings("unchecked")
	@ApiMethod(path = "dashboard", name="dashboard", httpMethod = "GET")
	public Dashboard getDashboard() {
		EntityManager mgr = getEntityManager();
		Dashboard dashboard = new Dashboard();
		try {
			//count hotels
			Query query = mgr.createQuery("select COUNT(id) from Hotel h");
			dashboard.setNbHotels((int)(long)((Long) query.getSingleResult()));
			//city
			Query query2 = mgr.createQuery("select h.city from Hotel as h");
			query2.setMaxResults(50);
			dashboard.setCityList(new ArrayList<String>(new HashSet<String>(query2.getResultList())));
			//country
			Query query3 = mgr.createQuery("select h.country from Hotel as h");
			query3.setMaxResults(50);
			dashboard.setCountryList(new ArrayList<String>(new HashSet<String>(query3.getResultList())));
		}catch (NoResultException e) {
			dashboard.setNbHotels(0);
			dashboard.setCityList(new ArrayList<String>());
			dashboard.setCountryList(new ArrayList<String>());
		} finally {
			mgr.close();
		}
		return dashboard;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
