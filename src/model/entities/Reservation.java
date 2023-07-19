package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

import java.text.SimpleDateFormat;

public class Reservation {

	private Integer number;
	private Date checkIn;
	private Date checkOut;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer number, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException ("CheckOut date must be after checkIn Date"); //o compilador quer q eu trate ela ou propague ela
			//como vamos propagar, colocamos ela na assinatura do método throws DomainException, simbolizando que o método pode lançar uma exceção
		} //programação defensiva, tratar exceções no começo dos métodos
		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Reservation() {}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException{
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) { //lanço uma exceçao caso algo errado ocorra
			throw new DomainException ("Error, the dates must be future dates"); //crio um objeto de exceção falando q o argumento é ilegal
		}
		
		if(!checkOut.after(checkIn)) {
			throw new DomainException ("CheckOut date must be after checkIn Date"); //o compilador quer q eu trate ela ou propague ela
			//como vamos propagar, colocamos ela na assinatura do método throws DomainException, simbolizando que o método pode lançar uma exceção
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Room "
			+ number
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}

}
