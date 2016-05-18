package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class SearchFligh
 */
@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlight() {
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
		String path = "Display.jsp";
		
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String depart=request.getParameter("departuredate");
		String arival="2016-7-11";
		String passenger=request.getParameter("passenger");
		if(!from.equalsIgnoreCase(to))
		{
		if("Toronto".equalsIgnoreCase(from)){
			request.setAttribute("from",from);
			request.setAttribute("to",to);
			request.setAttribute("depart",depart);
			request.setAttribute("arival",arival);
			request.setAttribute("passenger",passenger);
			request.setAttribute("fare","300");
			request.setAttribute("flightname","ConJet6312");
			
		}
		else if("Montreal".equalsIgnoreCase(from)){
			request.setAttribute("from",from);
			request.setAttribute("to",to);
			request.setAttribute("depart",depart);
			request.setAttribute("arival",arival);
			request.setAttribute("passenger",passenger);
			request.setAttribute("fare","400");
			request.setAttribute("flightname","ConJet7799");
			
		}
		else{
			request.setAttribute("from",from);
			request.setAttribute("to",to);
			request.setAttribute("depart",depart);
			request.setAttribute("arival",arival);
			request.setAttribute("passenger",passenger);
			request.setAttribute("fare","200");
			request.setAttribute("flightname","ConJet0011");
			
		}
		}
		else{
			path = "FlightMain.jsp";
			request.setAttribute("error","Departure and Arrial city can not be same.");
		}
		// hard codded
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);	
	}

}
