package br.desafio.exceptions;

public class ProblemaDeRedeDoSiteException extends Exception {
	private String mensagem;
	
	public ProblemaDeRedeDoSiteException(String mensagem) {
		this.mensagem = mensagem;
	}
}
