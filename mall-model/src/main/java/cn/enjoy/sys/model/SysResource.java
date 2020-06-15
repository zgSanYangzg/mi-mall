package cn.enjoy.sys.model;

import java.io.Serializable;
import java.util.Date;

public class SysResource implements Serializable{

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.name
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.code
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.parent_id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String parentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.identifying
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Integer identifying;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.url
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.icon
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String icon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.type
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Integer type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.sort_no
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Integer sortNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.status
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Integer status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.create_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.create_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.update_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private String updateUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_resource.update_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	private Date updateTime;

	private String parentName;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.id
	 * @return  the value of sys_resource.id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.id
	 * @param id  the value for sys_resource.id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.name
	 * @return  the value of sys_resource.name
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.name
	 * @param name  the value for sys_resource.name
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.code
	 * @return  the value of sys_resource.code
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.code
	 * @param code  the value for sys_resource.code
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.parent_id
	 * @return  the value of sys_resource.parent_id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.parent_id
	 * @param parentId  the value for sys_resource.parent_id
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.identifying
	 * @return  the value of sys_resource.identifying
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Integer getIdentifying() {
		return identifying;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.identifying
	 * @param identifying  the value for sys_resource.identifying
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setIdentifying(Integer identifying) {
		this.identifying = identifying;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.url
	 * @return  the value of sys_resource.url
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.url
	 * @param url  the value for sys_resource.url
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.icon
	 * @return  the value of sys_resource.icon
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.icon
	 * @param icon  the value for sys_resource.icon
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.type
	 * @return  the value of sys_resource.type
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.type
	 * @param type  the value for sys_resource.type
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.sort_no
	 * @return  the value of sys_resource.sort_no
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Integer getSortNo() {
		return sortNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.sort_no
	 * @param sortNo  the value for sys_resource.sort_no
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.status
	 * @return  the value of sys_resource.status
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.status
	 * @param status  the value for sys_resource.status
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.create_user
	 * @return  the value of sys_resource.create_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.create_user
	 * @param createUser  the value for sys_resource.create_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.create_time
	 * @return  the value of sys_resource.create_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.create_time
	 * @param createTime  the value for sys_resource.create_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.update_user
	 * @return  the value of sys_resource.update_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.update_user
	 * @param updateUser  the value for sys_resource.update_user
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_resource.update_time
	 * @return  the value of sys_resource.update_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_resource.update_time
	 * @param updateTime  the value for sys_resource.update_time
	 * @mbggenerated  Tue Jun 14 11:21:53 CST 2016
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}