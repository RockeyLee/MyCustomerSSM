package main.java.com.rockey.ssm.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {
	private FilterConfig config;
	private String encode;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(new MyRequest((HttpServletRequest) request), response);

	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		encode = config.getInitParameter("encode");
	}

	class MyRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;
		private boolean isFirstEnode = true;

		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			return getParameterValues(name) == null ? null
					: getParameterValues(name)[0];
		}

		@Override
		public Map getParameterMap() {
			// TODO Auto-generated method stub
			try {
				if (request.getMethod().equalsIgnoreCase("POST")) {
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
				} else if (request.getMethod().equalsIgnoreCase("GET")) {
					Map<String, String[]> map = request.getParameterMap();
					if (isFirstEnode) {
						for (Map.Entry<String, String[]> entry : map.entrySet()) {
							String[] var = entry.getValue();
							for (int i = 0; i < var.length; i++) {
								var[i] = new String(var[i]
										.getBytes("iso8859-1"), encode);
							}
						}
						isFirstEnode = false;
					}
					return map;
				} else {

					return request.getParameterMap();
				}

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		@Override
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			return (String[]) getParameterMap().get(name);
		}

	}

}
