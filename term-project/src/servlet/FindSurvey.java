package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Survey;
import util.SessionUtil;

@WebServlet("/FindSurvey")
public class FindSurvey extends HttpServlet {
    
    // https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
    
	private static final long serialVersionUID = 1L;
	private static final String SURVEY_QUERY = "FROM survey s WHERE s.name = :survey_name";
	private static final String NOT_FOUND = "survey-not-found.html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSurvey() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String surveyName = request.getParameter("surveyName");
	    PrintWriter output = response.getWriter();
	    
		Session session = SessionUtil.getSessionFactory().openSession();
		
		Query<Survey> query = session.createQuery(SURVEY_QUERY);
		query.setParameter("survey_name", surveyName);
		
		List<Survey> surveys = query.list();
		
		if (surveys.isEmpty()) {
		    request.getRequestDispatcher(NOT_FOUND).forward(request, response);
		}
		else {
		    // Assumes there will only be 1 query
		    displaySurvey(output, surveys.get(0));
		}
	}
	
	private void displaySurvey(PrintWriter output, Survey survey) {
	    // TODO: Implement display
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}