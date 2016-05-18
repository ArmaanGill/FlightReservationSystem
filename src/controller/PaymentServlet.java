package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.BookFlight;
import Bean.CreditCard;
import Bean.Flight;
import Bean.Payment;
import Bean.RegisteredUser;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			session=request.getSession(true);
			
			Flight flight= (Flight)session.getAttribute("flightInfo");
		    Payment payment =new Payment();
		    CreditCard card = new CreditCard(); 
		    RegisteredUser user = new RegisteredUser();
		   
			 String path = "Payment.jsp";
			BookFlight book = new BookFlight();
			String First=request.getParameter("First");
			String Last=request.getParameter("Last");
			String email=request.getParameter("email");
			String Phone=request.getParameter("Phone");
			String Meal=request.getParameter("Meal");
			String Card=request.getParameter("Card");
			String Expiration=request.getParameter("Expiration");
			String CSV=request.getParameter("CSV");
			
			user.setFirst_name(First);
			user.setLast_name(Last);
			user.setPhone_number(Long.parseLong(Phone));
			user.setEmail_id(email);
			book.setEmail_id(email);
			book.setMeal_preference(Meal);
			book.setPhone_number(Long.parseLong(Phone));
			book.setPassenger_name(First+" "+Last);
			card.setCard_holder_name(First+" "+Last);
			card.setCard_number(Long.parseLong(Card));
			
			String to =  flight.getArrival_city();
			String from = flight.getDeparture_city();
			String fnumber= flight.getFlight_number();
			Date depart= flight.getDeparture_date();
			Date arival = flight.getArrival_date();
			String fare = flight.getTrip();
			int passenger = flight.getNumber_of_passenger();
			
			
			payment.setAmount(Integer.parseInt(fare));
			request.setAttribute("name",First+" "+Last);
			request.setAttribute("email",email);
			request.setAttribute("Phone",Phone);
			request.setAttribute("Meal",Meal);
			request.setAttribute("to",to);
			request.setAttribute("from",from);
			request.setAttribute("fnumber",fnumber);
			request.setAttribute("depart",depart);
			request.setAttribute("arival",arival);
			request.setAttribute("passenger",passenger);
			request.setAttribute("fare",fare);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request,response);	
			
	}

}
