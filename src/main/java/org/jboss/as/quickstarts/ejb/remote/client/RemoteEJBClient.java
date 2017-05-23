package org.jboss.as.quickstarts.ejb.remote.client;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.univel.dao.AlunoDao;
import br.univel.model.Aluno;

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {

		invokeStatelessBean();

	}

	private static void invokeStatelessBean() throws NamingException {

		final AlunoDao dao = lookupRemoteStatelessCalculator();

		List<Aluno> lista = dao.getTodosAlunos();

		for (Aluno a : lista) {
			System.out.println(a.toString());
		}

	}

	private static AlunoDao lookupRemoteStatelessCalculator() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (AlunoDao) context.lookup("ejb:/AlunoServer/AlunoDaoImpl!" + AlunoDao.class.getName());
	}

}