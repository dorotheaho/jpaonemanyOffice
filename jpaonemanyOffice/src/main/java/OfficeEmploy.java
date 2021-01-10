

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Office;

/**
 * Servlet implementation class OfficeEmploy
 */
@WebServlet("/OfficeEmploy")
public class OfficeEmploy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeEmploy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaonemanyOffice");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Office office = new Office();
		office.setAddressLine1("Kanding");
		office.setCity("Taipei");
		office.setCountry("Taiwan");
		office.setOfficeCode("8");
		office.setPhone("02345678");
		office.setState("TW");
		office.setPostalCode("108");
		office.setTerritory("NA");
		
        Employee repto=new Employee();
        repto.setEmployeeNumber(1056);
		
		Employee e1 = new Employee();
		e1.setEmployeeNumber(9999);
		e1.setFirstName("KK");
		e1.setLastName("DDD");
		e1.setExtension("1234");
		e1.setEmail("abc@abc.com");
		e1.setOffice(office);
		e1.setJobTitle("good");
		e1.setEmployee(repto);

		
		Employee e2 = new Employee();
		e2.setEmployeeNumber(8888);
		e2.setFirstName("BB");
		e2.setLastName("JJJ");
		e2.setExtension("1234");
		e2.setEmail("abcddd@abc.com");
		e2.setOffice(office);
		e2.setJobTitle("good");
		e2.setEmployee(repto);

		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		office.setEmployees(list);
		
		em.persist(office);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		
		response.getWriter().append("Office employee Saved succssfully");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
