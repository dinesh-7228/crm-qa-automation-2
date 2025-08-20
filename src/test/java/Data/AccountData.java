package Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pradeep Singh
 *
 */
@Table
@Entity
public class AccountData {
	@Id
	@Column
	String rowid;
	@Column
	String testcaseid;
	@Column
	String username;
	@Column
	String password;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String confirmPassword;
	@Column
	String mobile;
	@Column
	String signupMail;
	@Column
	String signupPassword;
	@Column
	String cEmail;
	@Column
	String ShippingName;
	@Column
	String shippingAddressLine;
	@Column
	String ShippingAddressLineII;
	@Column
	String shippingLocality;
	@Column
	String ShippingPostalCode;
	@Column
	String CardNumber;
	@Column
	String shippingCardExpiry;
	@Column
	String CardCvc;
	@Column
	String SignUpSelectGender;
	@Column
	String MembershipPlanName;
	@Column
	String Discount;
	@Column
	String Sellingprice;
	@Column
	String Price;
	@Column
	String Maxbenefit;

	@Column
	String Validity;

	@Column
	String Addplanname;

	@Column
	String Addplandiscount;
	@Column
	String Addplansellingprice;

	@Column
	String Addplanprice;
	@Column
	String Addplanmaxbenefit;
	@Column
	String Addplanvalidity;

	@Column	
	String cityName;	
	@Column	
	String cityRegion;	
	@Column	
	String cityCode;	
	@Column	
	String areaName;	
	@Column	
	String areaLocality;	
	@Column	
	String TimeslotStartTime;	
	@Column	
	String TimeslotEndTime;	
	@Column	
	String LsProductTypeCategory;
	@Column	
	String ListRoleSequence;	
	@Column	
	String ListRoleDepartment;	
	@Column	
	String MessageName;	
	@Column	
	String TagType;	
	@Column	
	String StatusActive;	
	@Column	
	String VersionPlatform;	
	@Column	
	String EnterBSName;	
	@Column	
	String EnterProductCategoryName;	
	@Column	
	String AddRegionEnterName;	
	@Column	
	String ManualReportingSeverity;	
	@Column	
	String ManualReportingIssue;	
	@Column	
	String EnterScreenName;	
	@Column	
	String AutopayConfigSearch;	
	@Column	
	String WalletAmount;	
	@Column	
	String MinWalletAmount;	
	@Column	
	String MaxWalletAmount;	
	@Column	
	String RechargeAmount;	
	@Column	
	String MaxRechargeAmount;	
	@Column	
	String MinRechargeAmount;	
	@Column	
	String FaqTermsText;  	
	@Column	
	String BPFeedsName;	
	@Column	
	String CutOffYear;	
	@Column	
	String EnterCharge;	
	@Column	
	String EnterOrderAmountFrom;	
	@Column	
	String EnterOrderAmountTo;	
	@Column	
	String EnterPhoneNumber;	
	@Column	
	String EnterFeatureName;	
	@Column	
	String EnterCustomerID;
	@Column
	String EnterOpeningBalance;
	@Column
	String EnterClosingBalance;
	@Column
	String EnterTotalSale;
	@Column
	String DefaultPushConfigurationSearch;
	@Column
	String DefaultPushName;
	@Column
	String DefaultPushSubject;
	@Column
	String DefaultPushBody;
	@Column
	String DefaultPushUrl;
	@Column
	String DefaultPushTime;
	@Column 
	String RouteForWhatsAppChat;
	@Column
	String ConcernArea;
	@Column
	String EnterCampaign;

	/**
	 * @return the rowid
	 */
	public String getRowid() {
		return rowid;
	}
	/**
	 * @param rowid the rowid to set
	 */
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	/**
	 * @return the LoginType
	 */
	public String gettestcaseid() {
		return testcaseid;
	}
	/**
	 * @param testcaseid the baseurl to set
	 */
	public void settestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}
	/**
	 * @return the Email
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the browsername to set
	 */
	public void setUsername(String username
			) {
		this.username = username;
	}
	/**
	 * @return the emailAddress
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the browsername to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the Password
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSignupMail() {
		return signupMail;
	}

	public void setSignupMail(String signupMail) {
		this.signupMail = signupMail;
	}

	public String getSignupPassword() {
		return signupPassword;
	}

	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}

	public String getTestcaseid() {
		return testcaseid;
	}

	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getShippingName() {
		return ShippingName;
	}

	public void setShippingName(String shippingName) {
		ShippingName = shippingName;
	}

	public String getShippingAddressLine() {
		return shippingAddressLine;
	}

	public void setShippingAddressLine(String shippingAddressLine) {
		this.shippingAddressLine = shippingAddressLine;
	}

	public String getShippingAddressLineII() {
		return ShippingAddressLineII;
	}

	public void setShippingAddressLineII(String shippingAddressLineII) {
		ShippingAddressLineII = shippingAddressLineII;
	}

	public String getShippingLocality() {
		return shippingLocality;
	}

	public void setShippingLocality(String shippingLocality) {
		this.shippingLocality = shippingLocality;
	}

	public String getShippingPostalCode() {
		return ShippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		ShippingPostalCode = shippingPostalCode;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getShippingCardExpiry() {
		return shippingCardExpiry;
	}

	public void setShippingCardExpiry(String shippingCardExpiry) {
		this.shippingCardExpiry = shippingCardExpiry;
	}

	public String getCardCvc() {
		return CardCvc;
	}

	public void setCardCvc(String cardCvc) {
		CardCvc = cardCvc;
	}

	public String getSignUpSelectGender() {
		return SignUpSelectGender;
	}

	public void setSignUpSelectGender(String signUpSelectGender) {
		SignUpSelectGender = signUpSelectGender;
	}

	public String getMembershipPlanName() {
		return MembershipPlanName;
	}

	public void setMembershipPlanName(String MembershipPlanName) {
		MembershipPlanName = MembershipPlanName;
	}

	public String getDiscount() {
		return Discount;
	}

	public void setDiscount(String Discount) {
		Discount = Discount;
	}
	public String getSellingprice() {
		return Sellingprice;
	}

	public void setSellingprice(String Sellingprice) {
		Sellingprice = Sellingprice;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String Price) {Price= Price;}

	public String getMaxbenefit() {
		return Maxbenefit;
	}

	public void setMaxbenefit(String Maxbenefit) {Maxbenefit= Maxbenefit;}

	public String getValidity() {
		return Validity;
	}

	public void setValidity(String Validity) {Validity= Validity;}

	public String getAddplanname() {
		return Addplanname;
	}

	public void setAddplanname(String Addplanname) {Addplanname= Addplanname;}

	public String getAddplandiscount() {
		return Addplandiscount;
	}

	public void setAddplandiscount(String Addplandiscount) {Addplandiscount= Addplandiscount;}

	public String getAddplansellingprice() {
		return Addplansellingprice;
	}

	public void setAddplansellingprice(String Addplansellingprice) {Addplansellingprice= Addplansellingprice;}

	public String getAddplanprice() {
		return  Addplanprice;
	}

	public void setAddplanprice(String Addplanprice) {Addplanprice= Addplanprice;}

	public String getAddplanmaxbenefit() {
		return Addplanmaxbenefit;
	}

	public void setAddplanmaxbenefit(String Addplanmaxbenefit) {Addplanmaxbenefit= Addplanmaxbenefit;}

	public String getAddplanvalidity() {
		return Addplanvalidity;
	}

	public void setAddplanvalidity(String Addplanvalidity) {Addplanvalidity= Addplanvalidity;}



	public String getCityName() {	
		return cityName;	
	}	
	public void setCityName(String cityName) {	
		this.cityName = cityName;	
	}	
	public String getCityRegion() {	
		return cityRegion;	
	}	
	public void setCityRegion(String cityRegion) {	
		this.cityRegion = cityRegion;	
	}	
	public String getCityCode() {	
		return cityCode;	
	}	
	public void setCityCode(String cityCode) {	
		this.cityCode =cityCode;	
	}	
	public String getAreaName() {	
		return areaName;	
	}	
	public void setAreaName(String areaName) {	
		this.areaName = areaName;	
	}	
	public String getAreaLocality() {	
		return areaLocality;	
	}	
	public void setAreaLocality(String areaLocality) {	
		this.areaLocality = areaLocality;	
	}	
	public String getTimeslotStartTime() {	
		return TimeslotStartTime;	
	}	
	public void setTimeslotStartTime(String TimeslotStartTime) {	
		this.TimeslotStartTime = TimeslotStartTime;	
	}	
	public String getTimeslotEndTime() {	
		return TimeslotEndTime;	
	}	
	public void setTimeslotEndTime(String TimeslotEndTime) {	
		this.TimeslotEndTime = TimeslotEndTime;	
	}	
	public String getLsProductTypeCategory() {	
		return LsProductTypeCategory;	
	}	
	public void setLsProductTypeCategory(String LsProductTypeCategory) {	
		this.LsProductTypeCategory = LsProductTypeCategory;	
	}	
	public String getListRoleSequence() {	
		return ListRoleSequence;	
	}	
	public void setListRoleSequence(String ListRoleSequence) {	
		this.ListRoleSequence = ListRoleSequence;	
	} 	
	public String getListRoleDepartment() {	
		return ListRoleDepartment;	
	}	
	public void setListRoleDepartment(String ListRoleDepartment) {	
		this.ListRoleDepartment = ListRoleDepartment;	
	}	

	public String getMessageName() {	
		return MessageName;	
	}	
	public void setMessageName(String MessageName) {	
		this.MessageName = MessageName;	
	}	
	public String getTagType() {	
		return TagType;	
	}	
	public void setTagType(String TagType) {	
		this.TagType = TagType;	
	}	
	public String getStatusActive() {	
		return StatusActive;	
	}	
	public void setStatusActive(String StatusActive) {	
		this.StatusActive = StatusActive;	
	}	
	public String getVersionPlatform() {	
		return VersionPlatform;	
	}	
	public void setVersionPlatform(String VersionPlatform) {	
		this.VersionPlatform = VersionPlatform;	
	}	
	public String getEnterBSName() {	
		return EnterBSName;	
	}	
	public void setEnterBSName(String EnterBSName) {	
		this.EnterBSName = EnterBSName;	
	}	

	public String getEnterProductCategoryName() {	
		return EnterProductCategoryName;	
	}	
	public void setEnterProductCategoryName(String EnterProductCategoryName) {	
		this.EnterProductCategoryName = EnterProductCategoryName;	
	}	
	public String getAddRegionEnterName() {	
		return AddRegionEnterName;	
	}	
	public void setAddRegionEnterName(String AddRegionEnterName) {	
		this.AddRegionEnterName = AddRegionEnterName;	
	}	
	public String getManualReportingSeverity() {	
		return ManualReportingSeverity;	
	}	
	public void setManualReportingSeverity(String ManualReportingSeverity) {
		this.ManualReportingSeverity = ManualReportingSeverity;	
	}
	public String getManualReportingIssue() {	
		return ManualReportingIssue;	
	}	
	public void setManualReportingIssue(String ManualReportingIssue) {	
		this.ManualReportingIssue = ManualReportingIssue;	
	}	
	public String getEnterScreenName() {	
		return EnterScreenName;	
	}	
	public void setEnterScreenName(String EnterScreenName) {	
		this.EnterScreenName = EnterScreenName;	
	}	
	public String getAutopayConfigSearch() {	
		return AutopayConfigSearch;	
	}	
	public void setAutopayConfigSearch(String AutopayConfigSearch) {	
		this.AutopayConfigSearch = AutopayConfigSearch;	
	}	
	public String getWalletAmount() {	
		return WalletAmount;	
	}	
	public void setWalletAmount(String WalletAmount) {	
		this.WalletAmount = WalletAmount;	
	}	
	public String getMinWalletAmount() {	
		return MinWalletAmount;	
	}	
	public void setMinWalletAmount(String MinWalletAmount) {	
		this.MinWalletAmount = MinWalletAmount;	
	}	
	public String getMaxWalletAmount() {	
		return MaxWalletAmount;	
	}	
	public void setMaxWalletAmount(String MaxWalletAmount) {	
		this.MaxWalletAmount = MaxWalletAmount;	
	}	
	public String getRechargeAmount() {	
		return RechargeAmount;	
	}	
	public void setRechargeAmount(String RechargeAmount) {	
		this.RechargeAmount = RechargeAmount;	
	}	
	public String getMaxRechargeAmount() {	
		return MaxRechargeAmount;	
	}	
	public void setMaxRechargeAmount(String MaxRechargeAmount) {	
		this.MaxRechargeAmount = MaxRechargeAmount;	
	}	
	public String getMinRechargeAmount() {	
		return MinRechargeAmount;	
	}
	public void setMinRechargeAmount(String MinRechargeAmount) {	
		this.MinRechargeAmount = MinRechargeAmount;	
	}	
	public String getFaqTermsText() {	
		return FaqTermsText;	
	}	
	public void setFaqTermsText(String FaqTermsText) {	
		this.FaqTermsText = FaqTermsText;	
	}	

	public String getBPFeedsName() {	
		return BPFeedsName;	
	}	
	public void setBPFeedsName(String BPFeedsName) {	
		this.BPFeedsName = BPFeedsName;	
	}	
	public String getCutOffYear() {	
		return CutOffYear;	
	}	
	public void setCutOffYear(String CutOffYear) {	
		this.CutOffYear = CutOffYear;	
	}	
	public String getEnterCharge() {	
		return EnterCharge;	
	}	
	public void setEnterCharge(String EnterCharge) {	
		this.EnterCharge = EnterCharge;	
	}	
	public String getEnterOrderAmountFrom() {	
		return EnterOrderAmountFrom;	
	}	
	public void setEnterOrderAmountFrom(String EnterOrderAmountFrom) {	
		this.EnterOrderAmountFrom = EnterOrderAmountFrom;	
	}	
	public String getEnterOrderAmountTo() {	
		return EnterOrderAmountTo;	
	}	
	public void setEnterOrderAmountTo(String EnterOrderAmountTo) {	
		this.EnterOrderAmountTo = EnterOrderAmountTo;	
	}	
	public String getEnterPhoneNumber() {	
		return EnterPhoneNumber;	
	}	
	public void setEnterPhoneNumber(String EnterPhoneNumber) {	
		this.EnterPhoneNumber = EnterPhoneNumber;	
	}	
	public String getEnterFeatureName() {	
		return EnterFeatureName;	
	}	
	public void setEnterFeatureName(String EnterFeatureName) {	
		this.EnterFeatureName = EnterFeatureName;	
	}	
	public String getEnterCustomerID() {	
		return EnterCustomerID;	
	}	
	public void setEnterCustomerID(String EnterCustomerID) {	
		this.EnterCustomerID = EnterCustomerID;	
	}	
	public String getEnterTotalSale() {
		return EnterTotalSale;
	}
	public void setEnterTotalSale(String EnterTotalSale) {
		this.EnterTotalSale = EnterTotalSale;
	}
	public String getEnterOpeningBalance() {
		return EnterOpeningBalance;
	}
	public void setEnterOpeningBalance(String EnterOpeningBalance) {
		this.EnterOpeningBalance = EnterOpeningBalance;
	}
	public String getEnterClosingBalance() {
		return EnterClosingBalance;
	}
	public void setEnterClosingBalance(String EnterClosingBalance) {
		this.EnterClosingBalance = EnterClosingBalance;
	}
	public String getDefaultPushConfigurationSearch() {
		return DefaultPushConfigurationSearch;
	}
	public void setDefaultPushConfigurationSearch(String DefaultPushConfigurationSearch) {
		this.DefaultPushConfigurationSearch = DefaultPushConfigurationSearch;
	}
	public String getDefaultPushName() {
		return DefaultPushName;
	}
	public void setDefaultPushName(String DefaultPushName) {
		this.DefaultPushName = DefaultPushName;
	}
	public String getDefaultPushSubject() {
		return DefaultPushSubject;
	}
	public void setDefaultPushSubject(String DefaultPushSubject) {
		this.DefaultPushSubject = DefaultPushSubject;
	}
	public String getDefaultPushBody() {
		return DefaultPushBody;
	}
	public void setDefaultPushBody(String DefaultPushBody) {
		this.DefaultPushBody = DefaultPushBody;
	}
	public String getDefaultPushUrl() {
		return DefaultPushUrl;
	}
	public void setDefaultPushUrl(String DefaultPushUrl) {
		this.DefaultPushUrl = DefaultPushUrl;
	}
	public String getDefaultPushTime() {
		return DefaultPushTime;
	}
	public void setDefaultPushTime(String DefaultPushTime) {
		this.DefaultPushTime = DefaultPushTime;
	} public String getRouteForWhatsAppChat() {
		return RouteForWhatsAppChat;
	}
	public void setRouteForWhatsAppChat(String RouteForWhatsAppChat) {
		this.RouteForWhatsAppChat = RouteForWhatsAppChat;
	}
	public String getConcernArea() {
		return ConcernArea;
	}
	public void ConcernArea(String ConcernArea) {
		this.ConcernArea = ConcernArea;


	}
	public String getEnterCampaign() {
		return EnterCampaign;
		}
		public void setEnterCampaign(String EnterCampaign) {
		this.EnterCampaign = EnterCampaign;
		}
}

