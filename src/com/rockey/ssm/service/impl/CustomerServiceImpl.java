package com.rockey.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rockey.ssm.exception.CustomException;
import com.rockey.ssm.mapper.CustomerMapper;
import com.rockey.ssm.po.Customer;
import com.rockey.ssm.po.Page;
import com.rockey.ssm.service.CustomerService;
import com.rockey.ssm.util.BasicUtil;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	public void addCust(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		int result = customerMapper.insert(customer);
		if(result<=0)
			throw new CustomException("插入失败");
	}

	public void batchDelCustById(String[] delIds) throws Exception {
		
		for(int i= 0;i<delIds.length;i++){
			int id = Integer.parseInt(delIds[i]);
			int result = customerMapper.deleteByPrimaryKey(id);
			if(result<=0)
				throw new CustomException("批量删除失败");
		}
		// TODO Auto-generated method stub
		
	}

	public void deleteCust(String custId) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(custId);
		int result = customerMapper.deleteByPrimaryKey(id);
		if(result<=0)
			throw new CustomException("删除失败");
	}

	public List<Customer> findAllCust() throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.findAllCustomer();
	}

	public Customer findCustById(String custId) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(custId);
		return customerMapper.selectByPrimaryKey(id);
	}

	public void updateCust(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		int result = customerMapper.updateByPrimaryKey(customer);
		if(result<=0)
			throw new CustomException("插入失败");
	}

	public Page findCustShowInPage(int targetpage, Object object)
			throws Exception {
		// TODO Auto-generated method stub
		Page page = null;
		if(object!=null){
			page = (Page)object;
		}else{
			page = new Page();	
			//设置首页
			page.setFirstpage(1);
		}
		//设置每页条目数
		int rowpage = BasicUtil.getRowPage();
		page.setRowpage(rowpage);
		//设置当前数据总条目数
		int rowcount = customerMapper.countByExample(null);
		page.setRowcount(rowcount);
		//设置总页数
		int pagecount = rowcount/rowpage+(rowcount%rowpage==0?0:1);
		page.setPagecount(pagecount);
		//设置当前页,考虑删除最后一页最后一条数据
		int thispage = targetpage>=pagecount?pagecount:targetpage;
		page.setThispage(thispage);
		//设置尾页
		page.setLastpage(pagecount);
		//设置上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//设置下一页
		page.setNextpage(thispage==pagecount?pagecount:thispage+1);
		//设置分页查询起始页
		int frompage = (thispage-1)*rowpage;
		page.setFrompage(frompage);
		//获取并设置当前页数据
		List<Customer> list = customerMapper.findCustDividePage(page);
		page.setList(list);
		return page;
	}

	public List<Customer> findCustomerByConds(Customer customer)
			throws Exception {
		// TODO Auto-generated method stub
		List<Customer> list =customerMapper.findCustomerByConds(customer);
		if(list==null||list.size()==0){
			throw new CustomException("未查到此数据");
		}
		return list;
	}

}
