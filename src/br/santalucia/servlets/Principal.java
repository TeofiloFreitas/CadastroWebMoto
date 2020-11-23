package br.santalucia.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.santalucia.beans.Usuario;
import br.santalucia.dao.UsuarioDAO;


@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Principal() {
        super();   
    }
    
    // Mostrar Usuario 
    @WebServlet("/mostrarUsuario")
    public class MostraUsuario extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
        public MostraUsuario() {
            super();
        }
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		String paramId = request.getParameter("id");
    		int id = Integer.parseInt(paramId);
    		
    		UsuarioDAO dao = new UsuarioDAO();
    		Usuario u = dao.pegaUsuario(id);
    		request.setAttribute("usuario", u);
    		RequestDispatcher rd = request.getRequestDispatcher("/alteraUsuarioForm.jsp");
    		rd.forward(request, response);	
    	}
    }
    
    // Listar Usuarios
    @WebServlet("/listarUsuarios")
    public class ListaUsuarios extends HttpServlet {
    	private static final long serialVersionUID = 1L;
        
        public ListaUsuarios() {
            super();
        }
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		UsuarioDAO dao = new UsuarioDAO();
    		List<Usuario> usuarios = dao.listarUsuarios();
    		
    		RequestDispatcher rd = request.getRequestDispatcher("/Usuarios.jsp");
    		request.setAttribute("usuarios", usuarios);
    		rd.forward(request, response);
    	}
    }
    
    // Excluir Usuarios
    @WebServlet("/excluirUsuario")
    public class ExcluiUsuario extends HttpServlet {
    	private static final long serialVersionUID = 1L;
       
        public ExcluiUsuario() {
            super();
        }
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String paramId = request.getParameter("id");
    		System.out.println(paramId);
    		Integer id = Integer.parseInt(paramId);
    		
    		UsuarioDAO dao = new UsuarioDAO();
    		dao.excluirUsuario(id);
    		
    		response.sendRedirect("listarUsuarios");
    	}
    }
    
    // Cadastrar Usuario
    @WebServlet("/cadastrarUsuario")
    public class CadastraUsuario extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
        public CadastraUsuario() {
            super();
        }
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		String marca = request.getParameter("marca");
    		String modelo = request.getParameter("modelo");
    		String ano = request.getParameter("ano");
    		String paramId = request.getParameter("id");
    		
    		
    		Usuario u = new Usuario();
    		
    		u.setMarca(marca);
    		u.setModelo(modelo);
    		u.setAno(ano);
    		
    		UsuarioDAO dao = new UsuarioDAO();
    		if(paramId==null) {
    			System.out.println("Adicionando nova moto...");
    			dao.adicionaUsuario(u);
    		} else {	
    			Integer id = Integer.parseInt(paramId);
    			u.setId(id);
    			System.out.println("Alterando moto...");
    			dao.alterarUsuario(u);
    		}
  
    		response.sendRedirect("listarUsuarios");
    	}
    }
    
    // Alterar Usuario
    @WebServlet("/alterarUsuario")
    public class AlteraUsuario extends HttpServlet {
    	private static final long serialVersionUID = 1L;
        
        public AlteraUsuario() {
            super();
        }
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		String paramId = request.getParameter("id");
    		String paramMarca = request.getParameter("marca");
    		String paramModelo = request.getParameter("modelo");
    		String paramAno = request.getParameter("ano");
    		int id = Integer.parseInt(paramId);
    		
    		Usuario u = new Usuario();
    		u.setId(id);
    		u.setMarca(paramMarca);
    		u.setModelo(paramModelo);
    		u.setAno(paramAno);
    		
    		UsuarioDAO dao = new UsuarioDAO();
    		dao.alterarUsuario(u);
    		
    		response.sendRedirect("listarUsuarios");
    		
    	}

    }
    
}



	
