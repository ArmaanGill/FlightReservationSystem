package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

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

/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public static ArrayList<String> flightInfo;
      public Flight flight= new Flight();
      public Payment payment =new Payment();
      public CreditCard card = new CreditCard();
      private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String path = "UserInfo.jsp";
		String fare = request.getParameter("fare");
		String arival =request.getParameter("arivaldate");
		String from =request.getParameter("from");
		String to =request.getParameter("to");
		String depart= request.getParameter("departuredate");
		
		String passenger =request.getParameter("passenger");
		String fnumber= request.getParameter("fnumber");
		//----------------------------------
		
		flight.setArrival_city(to);
//		flight.setArrival_date(Date.valueOf(arival));
		flight.setDeparture_city(from);
		flight.setDeparture_date(Date.valueOf(depart));
		flight.setNumber_of_passenger(Integer.parseInt(passenger));
		flight.setFlight_number(fnumber);
		flight.setTrip(fare);
		request.setAttribute("flightInfo",flight);
		session.setAttribute("flightInfo",flight);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
		
	
	}

}
