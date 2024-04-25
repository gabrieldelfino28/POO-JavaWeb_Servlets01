package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;

import java.io.IOException;

@WebServlet("/contaespecial") //o form action="" referencia aqui
public class ContaEspecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ContaEspecial contaEspecial;
	
    public ContaEspecialServlet() {

    	contaEspecial = new ContaEspecial();
    	contaEspecial.setCliente("Claudio");
    	contaEspecial.setNumConta(301);
    	contaEspecial.setSaldo(2000);
    	contaEspecial.setLimite(500);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		String saque = request.getParameter("saque");
		String deposito = request.getParameter("deposito");
		String saida = "";
		
		try {
			if (cmd.equals("Saque")) {
				contaEspecial.sacar(Float.parseFloat(saque));
				saida = "Saque realizado com sucesso!";
				request.setAttribute("saida", saida);
			}
			else if(cmd.equals("Deposito")) {
				contaEspecial.depositar(Float.parseFloat(deposito));
				saida = "Deposito realizado com sucesso!";
				request.setAttribute("saida", saida);
			}
			else if (cmd.equals("Consulta")) {
				request.setAttribute("contaEspecial", contaEspecial);
			}
		}catch(Exception e) {
			saida = e.getMessage();
			request.setAttribute("saida", saida);
		}
		
		//dispatcher = retorno
		RequestDispatcher rd = request.getRequestDispatcher("especial.jsp");
		rd.forward(request, response);
	}
}
