package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Survey;
import util.SessionUtil;

@WebServlet("/ViewSurvey")
public class ViewSurvey extends HttpServlet {
    
    // https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
    
	private static final long serialVersionUID = 1L;
	private static final String SURVEY_QUERY = "FROM survey s WHERE s.name = :survey_name";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSurvey() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = SessionUtil.getSessionFactory().openSession();
		
		Query<Survey> query = session.createQuery(SURVEY_QUERY);
		query.setParameter("survey_name", request.getParameter("surveyName"));
		
		Survey survey = query.list().get(0);
		
		// TODO: add display for webpage from survey content
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}