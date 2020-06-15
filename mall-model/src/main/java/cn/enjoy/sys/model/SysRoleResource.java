package cn.enjoy.sys.model;

import java.io.Serializable;
import java.util.Date;

public class SysRoleResource implements Serializable{

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.role_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private String roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.resource_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private String resourceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.create_user
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.create_time
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private Date createTime;


	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_role_resource.status
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	private String status;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.id
	 * @return  the value of sys_role_resource.id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.id
	 * @param id  the value for sys_role_resource.id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.role_id
	 * @return  the value of sys_role_resource.role_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.role_id
	 * @param roleId  the value for sys_role_resource.role_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.resource_id
	 * @return  the value of sys_role_resource.resource_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.resource_id
	 * @param resourceId  the value for sys_role_resource.resource_id
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId == null ? null : resourceId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.create_user
	 * @return  the value of sys_role_resource.create_user
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.create_user
	 * @param createUser  the value for sys_role_resource.create_user
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.create_time
	 * @return  the value of sys_role_resource.create_time
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.create_time
	 * @param createTime  the value for sys_role_resource.create_time
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_role_resource.status
	 * @return  the value of sys_role_resource.status
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_role_resource.status
	 * @param status  the value for sys_role_resource.status
	 * @mbggenerated  Fri Jul 15 11:04:49 CST 2016
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
}