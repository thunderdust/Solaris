Catalog - Solaris
======

**Your Name:** Liu Weiran

**Submission number:** 2

**Last-Modified Date:** 03/08/2016

---

## Chapter 1 - Describe the business situation of 'R&D3' with "5W1H"
**1. What is your business model? Describe industry, product, client, company size etc.**
         
    The business involved is direct sales of laptops. The product involved is laptops from all mainstream laptop brands (e.g. HP, Lenovo, Toshiba, Acer, Asus, etc. 
    
    The targeted client company is a small-scaled enterprise in infocomm products industry, with less than 50 employees, including manager(s), sales team, accounting team and marketing team. Enterprises which are aiming for business growths and are developing into bigger scales in future as also our clients.  

    Our application helps clients to increase their sales productivity and management efficiency at a low cost (to purchase the software) so that they can concentrate on growing their business and make more profits within the same unit of time.
    

**2. Who do you think would be involved in your business? List up role, person, or group as many as possible.**

    Three different groups of user get involved in this business: administrators, sales representatives, and marketing executives.
     
    [Administrators] 
    General manager of the business. This role is also in charge of managing the employees in the company.
    
    [Sales Representatives] 
    Formed by the employees of sales team in the company. This is the most major group of users of the firm, who make the most of the profits for the business.
    
    [Marketing Executives] 
    Formed by the employees from marketing department of this company. They analyze current situations and make marketing plans and strategies for the company.


**3. Describe each of their work flow: WHAT are they responsible for? WHEN, WHERE and WHAT do they work?**

    Each of the 3 types of users involved in this business plays their own roles and collaborates with each other to deliver a better sales results for the company. 
    
    [ Administrator ]
    
    1) Management of employees:
    Working in his office, when there are new joiners, he is responsible to create the account and the profile for the new employee based on his role and personal information such as name, age, gender, email, contact number and so on. 
    At the end of a quarter or a year, administrator is also responsible for assessing and evaluating employees, and hence deciding the promotion or demotion of the them.
    
    [ Sales Representative]
    
    1) Sell products (laptops) to customers:
    Sales representative can work in his office, or at the appointment with clients. When sales representatives meet clients, their job is to sell laptops to clients by demonstrating products to clients, giving them suggestions or recommendations about which laptop to purchase, and eventually persuading them to buy the products.
        
    2) Submit sales results:
    When a deal with customers is finished, sales representatives need to submit the details of the deal (deal number, deal date, laptop model, quantity of purchase, deal price, client name, client contact information, etc) to the company.
    
    [ Marketing Executive ]
    
    1) Management of products:
    Marketing executives work in their offices. When it is necessary to launch new products, they ought to execute product addition; 
    When a product is outdated and abandoned by the market, they are responsible for product deletion; 
    
    2) Product promotions:
    When the sales for some products perform poorly or there is a demand to increase sales for certain products, it's the job of marketing executives to conduct product promotions.
    
    3) Market analysis and strategy making
    It's the responsibility of marketing executives to analyze the market situations and detect trends. They also need to combine the analysis result with the sales performances of the company, and think of marketing strategies for the upcoming future.  
    

---


## Chapter 2 - Details of the user profiles
Please provide profile for **ALL** users of your system. 

### [User A] 
Post/Position: General Manager

IT literacy: 
Limited knowledge about IT; Capable of using web applications 

Frequency of using the software: 
3 to 5 times per week

Purpose of using the software: 
1. Manage employees
2. Supervise the sales performances						

Situation of using the software: 

1. When new employee A join the company, GM needs to create an account for him:

    1)  Open up a new account for A;
    2)  Create a company identity number for A;
    3)  Record A's joining date; 
    4)  Record A's name, email address, contact number, home address;
    5)  Set the job title for A (sales representative, marketing executive etc.);
    6)  (If A is a sales representative) Set the initial sales target of A;
    7)  Set the basic salary of A;
    8)  Check all the information and confirm the new account ;
    9)  Notify A that his account in this company has been successfully set up.

2. When sales representative S resigns from the company, GM needs to deactivate S's account:

    1) Look up for S's account from the account book;
    2) Cross out the S's row on the records table; 
    3) Look up for S's account from the sales amount records book;
    4) Cross out his record page from the sales amount records book
    5) Cross out his name from the sales team 

3. When GM wants to check the sales performances of the sales representatives:

    1) Look up for sales representative A's record page from the sales amount records book;
    2) (With the help of accountant) Add up his sales amount record by record;
    3) Record down A's sales summary;
    4) Repeat step 1-3 for any sales representatives that GM wants to check, say B, C, D, E, F, ... etc.


Describe what user expects.

1. Effortlessly add / remove employee accounts
    
    Create or remove accounts of employees can be troublesome. As described above, to create an account is a tedious and repetitive work. The workflow to accomplish this task is very similar from time to time except for the differences in personal information. As for deletion of accounts, manager has to look up for the related records in multiple linked record tables ( When delete an account from employee list, his sales record table needs to be deactivated as well ). Therefore user wants to simplify these two tasks and make them less tedious. 
    
2. Reliable and secured management of employee information 
    
    The management of employee information can be challenging in terms of information security. How to keep all the sensitive information without leaking it to outside of company is a serious challenging for the manager.  Traditional way of keeping everything on paper is not secured enough: the information can be damaged or leaked out easily. User expects a more reliable, secured method to manage the employee information. 
    
3. Convenient and up-to-date way to check sales performances

    By the traditional way supervising sales performances is inefficient. Every time when the manager wants to check some sales representative's performance, he has to look up for this person's sales records from a large number of rows, and then asks the accountant to add up all sales amount of this person before he can actually sees the sales performance. This is slow, inefficient and very inconvenient. The worse part is that the calculated sales result of this person is not real-time, meaning the result does not include deals of this person submitted after the start of the calculation (This could happen because the time spend from start looking up for the sales person's records to finally obtain the sales amount can be very long). Hence the manager would be very glad to have a faster mechanism to check the up-to-date sales performances.
    
Your proposal to solve the object

1. Implement a function in the Solaris application specifically for employee management. Use elegant user interfaces and workflow to simplify the process of adding / removing user accounts:  
- Identity number will be auto-generated and saved 
- Account creation date is current date by default 
- Use input validations where applicable to reduce the chance for errors. For example, check the email format automatically to prevent invalid email address; or check if the employee name is an empty input to prevent absence of information 
- Provide auto-completion where applicable to speed up the process of creating account. For example, use selection menu for the "job title" input field with options of manager, sales, marketing etc. And once an option is selected, the system will fill in the basic salary automatically (assuming for each type of job the basic salary is pre-defined, and if not manager can always amend it manually). 

2. Information of each employee will be stored in the same schema as a data entity with encryption, from where the read / addition / modification / deletion is executed. This mechanism will protect the information from leaking out. 
Each employee will be assigned an account for the use of ONLY himself which is protected by a unique password. This will ensure the privacy of each employee is protected, and make sure they can only access data that belongs to themselves.

3. Build sales report function to meet manager's requirement of sales performance supervision: Individual sales person can be located easily with a single operation of search (by name or company identity number), and his sales amount will be calculated dynamically upon the search request. This is much faster than manually looking up for his records and sum them up, and therefore achieves up-to-date sales performance check as well. 


### [User B] 
Post/Position:  
Sales Representative

IT literacy: 
Basic IT knowledge; Able to use web appplications

Frequency of using the software: 
Daily

Purpose of using the software: 
Assist sales activities by demonstrating products to clients and making purchase recommendations to them; Report sales results 

Situation of using the software: 
1. When meeting clients and showing them about specifications of some laptops;
2. When clients have some expectations and requirements for the laptop they want to purchase and request for recommendations;
3. When sales representatives finish a deal with clients, and need to submit the deal details to the system. 

Describe what user expects.
1. Powerful demonstration functions to showcase every details about the products 
2. Savy and flexible recommendation function to suit customer's needs the most
3. Convenient gateway to report sales results 

Your proposal to solve the object
1. Design a complete and fully-detailed database schema to store product information. This database must contain every details about the product, including but not limited to:
   - Laptop name
   - model
   - brand
   - series number
   - dimensions
   - weight
   - battery volume
   - screen size
   - memory size
   - hard disk volume
   - processor model
   - profile images
   
1. Design elegant and attracting user interface to enhance the visual effects of demonstrations. Support the demonstrations with powerful search functions which can help sale representatives locate the product they want to show to clients within shortest time.
   
2. Design a search function which filters products by user's preferences such as brand, size, weight, screen size, price range, battery performance, hardware specifications etc. On top of that, assign each laptop with one or a few tags which describes the specialized features of the product. For instance, [Gaming Laptop] tag for products with high performance on display effect and game processing; or [Specialized for Girls] tag for laptops which are fancy, light-weighted and easy-to-use. The recommendation function will choose products for target clients based on the filters and tags aforementioned. 

3. Design the sales submission function for sales representatives such that they can update their sales performance efficiently. Use elegant user interfaces and workflow to simplify the process of submission. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency. 

### [User C] 
Post/Position: 
Marketing Executive

IT literacy: 
Limited knowledge about IT; Capable of using web applications 

Frequency of using the software: 
Daily

Purpose of using the software: 
Adjust product managements to fit the marketing strategies; Analyze sales performances to assist the creation of marketing strategies; Initiate product promotions.

Situation of using the software: 
1. When there is a need to introduce new products according to marketing strategies. 
2. When there is a need to discard some products due to bad sales performance or vanishing market demands.
3. When marketing executives need to use the sales performance summary to assit marketing analysis.
4. When there is a need to launch a new promotion for some products to stimulate sales.

Describe what user expects.
1. Convenient and simple operations for add/remove products
2. Easy access to sales performances
3. Functionality to support launch of promotions

Your proposal to solve the object
1. Design a function specifically for product management. Use elegant user interfaces and workflow to simplify the process of adding / removing products. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency.
2. Authorize the access to sales reports to all marketing executive roles. When marketing executives logs into the system with their own account, they have the sales report sections displayed by default. 
3. Build promotion functionality which can apply to selected list of products. The items in a list can be selected by specifying models, brands, tags or other customized standards. Users can also set the promotion name, valid period, discount amount etc. 


---
## Chapter 3 - Descriptions of each "Merit"

### [Merit 1] -- Support product promotions

The application can stimulate sales by promotions. When customized promotions are applied to certain product list, all items under the list will have some discounts to attract customers accordingly. 

#### [Function 1: Promotion Creation]

**Priority:** High

**Implemented:** N

#### [Function 2: Promotion Inquiry]

**Priority:** Medium

**Implemented:** N

### [Merit 2] -- Sales report assistant
The application is capable of delivering basic and advanced data to assist accountants to produce the sales report, which will be used by marketing executives and examed by general managers.
#### [Function 1: Sales Summary]

**Priority:** High

**Implemented:** N

#### [Function 2: Customized Data Inquiry]

**Priority:** Low

**Implemented:** N

#### [Function 3: Advanced Sales Statistics Generation]

**Priority:** Medium

**Implemented:** N

---

## Chapter 4 - ReadMe

[This will serve as a guide to the users of your system]

---

## Chapter 5 - Improvement Content List

#### Correspondence N
**Date:** [Date]

**Feedback:** 
- [Feedback]
- [Feedback]
- [Feedback]

**Result:**
- [Improvement]
- [Improvement]
- [Improvement]