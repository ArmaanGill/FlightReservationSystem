package Bean;

public class CreditCard extends Payment {

	/**
	 * 
	 */
	private Long card_number;
	/**
	 * 
	 */
	private String card_holder_name;
	/**
	 * Getter of card_number
	 */
	public Long getCard_number() {
	 	 return card_number; 
	}
	/**
	 * Setter of card_number
	 */
	public void setCard_number(Long card_number) { 
		 this.card_number = card_number; 
	}
	/**
	 * Getter of card_holder_name
	 */
	public String getCard_holder_name() {
	 	 return card_holder_name; 
	}
	/**
	 * Setter of card_holder_name
	 */
	public void setCard_holder_name(String card_holder_name) { 
		 this.card_holder_name = card_holder_name; 
	} 

}
