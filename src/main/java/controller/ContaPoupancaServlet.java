package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaPoupanca;

import java.io.IOException;

@WebServlet("/contapoupanca")
public class ContaPoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaPoupanca contaPoupanca;
    public ContaPoupancaServlet() {
    	contaPoupanca = new ContaPoupanca();
    	contaPoupanca.setCliente("Fernando");
    	contaPoupanca.setNumConta(248);
    	contaPoupanca.setDiaRendimento(31);
    	contaPoupanca.setSaldo(2000);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("poupanca.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("enviar");
		String saque = request.getParameter("saque");
		String deposito = request.getParameter("deposito");
		String saida = "";
		
		try {
			if (cmd.equals("Saque")) {
				contaPoupanca.sacar(Float.parseFloat(saque));
				saida = "Saque realizado com sucesso!";
				request.setAttribute("saida", saida);
			}
			else if(cmd.equals("Deposito")) {
				contaPoupanca.depositar(Float.parseFloat(deposito));
				saida = "Deposito realizado com sucesso!";
				request.setAttribute("saida", saida);
			}
			else if(cmd.equals("Calcular")) {
				contaPoupanca.calcularNovoSaldo();
				saida = "Saldo atualizado!\nNovo Saldo: "+contaPoupanca.getSaldo();
				request.setAttribute("saida", saida);
			}
			else if (cmd.equals("Consulta")) {
				request.setAttribute("contaPoupanca", contaPoupanca);
			}
		}catch(Exception e) {
			saida = e.getMessage();
			request.setAttribute("saida", saida);
		}
		
		//dispatcher = retorno
		RequestDispatcher rd = request.getRequestDispatcher("poupanca.jsp");
		rd.forward(request, response);
	}

}
