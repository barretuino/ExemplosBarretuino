package br.barretuino.servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.barretuino.modelagem.Departamento;
import br.barretuino.modelagem.Produto;
import br.barretuino.modelagem.UnidadeMedida;

@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Produto> produtos;
	Map<Integer, UnidadeMedida> unidadeMedida;
	Map<Integer, Departamento> departamento;
	
	public ProdutoController(){
		initController();
	}
	
	private void initController() {
		produtos = new ArrayList<Produto>();
		unidadeMedida = new HashMap<Integer, UnidadeMedida>();		
		unidadeMedida.put(1, new UnidadeMedida(1, "kg"));
		unidadeMedida.put(2, new UnidadeMedida(2, "un"));
		unidadeMedida.put(3, new UnidadeMedida(3, "lt"));
		unidadeMedida.put(4, new UnidadeMedida(4, "m"));
		unidadeMedida.put(5, new UnidadeMedida(5, "pc"));
		departamento = new HashMap<Integer, Departamento>();
		departamento.put(1, new Departamento(1, "Bebidas"));
		departamento.put(2, new Departamento(2, "Frios"));
		departamento.put(3, new Departamento(3, "Cereais"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
		
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setDescricao(request.getParameter("descricao"));		
		produto.setUnidadeMedida(unidadeMedida.get(Integer.parseInt(request.getParameter("unidadeMedida"))));
		String data = request.getParameter("dataCadastro");
		int ano = Integer.parseInt(data.substring(0, 4)) - 1900;
		int mes = Integer.parseInt(data.substring(5, 7)) - 1;
		int dia = Integer.parseInt(data.substring(8, 10));		
		produto.setDataCadastro(new Date(ano, mes, dia));		
		produto.setUltimaAlteracao(new Date(System.currentTimeMillis()));
		produto.setDepartamento(departamento.get(Integer.parseInt(request.getParameter("departamento"))));
		produto.setAtivo(request.getParameter("ativo") == "true" ? true : false);
		
		produtos.add(produto);
	}
}