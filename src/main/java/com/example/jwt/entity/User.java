package com.example.jwt.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User  {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String account;//登陆账号名称
	private String userName;//用户姓名
	private String passwd;//登陆密码
	private Integer unitId = 0;//单位编号
	private Integer partId=0;//部门编号
	private Integer roleId=0;//角色编号
	private String tel;//联系电话
	private String userPic;//用户头像
	private String userCode;//用户工号
	private Integer status;//状态 0：新建用户 -1：被删除 -2：被停用
	private Date lastLoginTime;//最后登陆时间
	private Integer loginTimes;//总登陆次数
	private Integer isRoot;//0不是超级用户 1是超级用户
	private Integer postId=0;//职务编号
	private Date createTime ;//创建时间
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Integer getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(Integer isRoot) {
		this.isRoot = isRoot;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", account='" + account + '\'' +
				", userName='" + userName + '\'' +
				", passwd='" + passwd + '\'' +
				", unitId=" + unitId +
				", partId=" + partId +
				", roleId=" + roleId +
				", tel='" + tel + '\'' +
				", userPic='" + userPic + '\'' +
				", userCode='" + userCode + '\'' +
				", status=" + status +
				", lastLoginTime=" + lastLoginTime +
				", loginTimes=" + loginTimes +
				", isRoot=" + isRoot +
				", postId=" + postId +
				", createTime=" + createTime +
				'}';
	}
}
