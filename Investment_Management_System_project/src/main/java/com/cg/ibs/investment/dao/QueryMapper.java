package com.cg.ibs.investment.dao;

public interface QueryMapper {
	
	
	
	public static final String VIEW_MY_MF = "select mutual_fund.mf_id ,bank_mutual_fund.mf_plan_id,bank_mutual_fund.mf_title, bank_mutual_fund.nav,mutual_fund.mf_units ,mutual_fund.mf_amount ,mutual_fund.opening_date,mutual_fund.closing_date from MUTUAL_FUND  Inner JOIN Bank_mutual_fund on mutual_fund.mf_plan_id=bank_mutual_fund.mf_plan_id where mutual_fund.uci =?";
	public static final String GET_UCI="select c from CustomerBean c where c.userId=?1";
	public static final String VIEW_BANK_MF="SELECT mf_plan_id, mf_title, nav FROM bank_mutual_fund";
	public static final String GET_ACCOUNT_BY_UCI="SELECT account_number, uci, current_balance From accounts WHERE uci=? ";
	public static final String VIEW_MY_INVESTMENTS="SELECT investment_bean.uci, investment_bean.account_number, investment_bean.gold_units, investment_bean.silver_units, accounts.current_balance   FROM investment_bean LEFT JOIN accounts ON investment_bean.uci = accounts.uci WHERE investment_bean.uci=?";
	public static final String VIEW_MY_BALANCE="Select current_balance FROM accounts WHERE account_number=?";
	public static final String VIEW_MY_TRANSACTIONS="SELECT account_number , trans_id , trans_type  , trans_date_time , amount , description ,units,price_per_unit FROM transaction WHERE account_number=?";
	public static final String VIEW_GOLD_PRICE = "SELECT gold_price FROM gold_price WHERE update_date = ( SELECT MAX(update_date) FROM gold_price )";
	public static final String VIEW_SILVER_PRICE = "SELECT silver_price FROM silver_price WHERE update_date = ( SELECT MAX(update_date) FROM silver_price )";
	public static final String UPDATE_GOLD_PRICE = "insert into gold_price values(?,?)";
	public static final String UPDATE_SILVER_PRICE = "insert into silver_price values(?,?)";
	public static final String GOLD_UNITS = "update investment_bean set gold_units=? where uci=?";
	public static final String SILVER_UNITS = "update investment_bean set silver_units=? where uci=?";
	public static final String BALANCE = "UPDATE accounts SET current_balance=? WHERE account_number=?";
	public static final String GET_CUSTOMER="SELECT user_id, password, uci FROM customers WHERE user_id=?";
	public static final String GET_BANK_ADMIN="SELECT admin_id, password FROM bank_admins WHERE admin_id=?";
	public static final String INSERT_TRANSACTION="INSERT INTO transaction VALUES(?,?,?,?,?,?,?,?)";
	public static final String ADD_MF="INSERT INTO bank_mutual_fund values(?,?,?) ";
    public static final String INVEST_MF = "INSERT INTO mutual_fund values(?,?,?,?,?,?,?)";
    public static final String WITHDRAW_MF="UPDATE mutual_fund SET closing_date=? WHERE mf_id=? ";
    public static final String SET_MY_ACCOUNT="UPDATE investment_bean SET account_number=? where uci=?";
    public static final String GET_MAX_UPDATE_DATE="SELECT gold_price FROM gold_price where update_date=?";
    public static final String GET_MAX_UPDATE_DATE_SILVER="SELECT silver_price FROM silver_price where update_date=?";
	
}
