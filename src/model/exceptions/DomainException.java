package model.exceptions;

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L; //customizo com o nome que eu quiser
	//pode ser uma exceção Exception ou runtimeexception a diferença é q o segundo o compilador n te obriga a tratar
	//o exception precisa ter uma versão, no caso de padrão o é valor 1

	public DomainException(String msg) {
		super(msg);
	}
	
}
