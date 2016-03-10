Catalog - Solaris
======

**Your Name:** Liu Weiran

**Submission number:** 02

**Last-Modified Date:** 03/10/2016

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

1. Present products, make suggestions and sell products to customers
2. Report sales results to the company

Situation of using the software: 

1. When sales meet clients for discussion of purchase
    If the client already knows what laptop to purchase, they need to demonstrate laptop information to clients upon request: 
   - laptop name
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
   - promotions for this laptop
   
   If the customer has no idea about how to choose a laptop, but has some expectations or requirements of the product, sales need to filter out products which satisfy customer's requirements. 
   
   If the customer totally has no ideas what kind of laptop to buy, sales representatives need to make suggestions for the clients based on some standards:
   - price range
   - brand
   - performance
   - appearance
   - featured usage (e.g. gaming laptop, business laptop, portable laptop, etc.) 
   - battery life
   - weight / size

2. When sales representatives finish a deal with clients, they need to submit the deal details back to the company:
    - deal date
    - laptop model sold
    - unit price
    - quantity of purchase
    - customer name
    - customer contact information

Describe what user expects.

1. An easy-to-operate but powerful demonstration to showcase products to customers as detailed as possible
    
    It is impossible for sales to bring all different models of laptops for the customers to choose. Hence presentation of laptops on a computer screen must be persuasive and convincing enough. The demonstration should be able to provide information of products as detailed as possible, yet not too complicated to operate or to watch. 

2. Being able to efficiently make recommendations based on various requirements of clients

    Clients can have all kinds of different requirements about their ideal laptops. At the same time, their only have limited patience. Hence it is hard for sales representatives to quickly find out the product(s) which match the customer needs. If they fail to do so, the business opportunity might be wasted. 

3. Conveniently submit deals results 
    
    Due to the nature of the work, sales representatives spend lots of their time working with the clients and often being out of the office. In a traditional manner, when one deal is done, they need to record the details down and go back to the office and report to whoever is managing the deal results. This is very troublesome and inefficient for both the sales and the staff who manages the deal results (Even if sales can report the results via a phone call or an email it still takes much extra time for the staff who manages sale results to process and record all the information). So it is very necessary to have a new way to submit deal results without so much trouble.

Your proposal to solve the object

1. Create a comprehensive and fully-detailed 'laptop library' to store information of all models of products that the company holds. Design an elegant, user-friendly interface in the application for the showcase to enhance visual effects. Use images of laptops with the actual dimensions to make it more vivid. Quantify the performance and battery life of laptops to give customers a more accurate and straightforward evaluation. 
   
2. Design powerful search functions which filters products by user's preferences such as brand, size, weight, screen size, price range, battery performance, hardware specifications etc. There can be more than one search criteria. On top of that, assign each laptop with one or a few tags which describes the specialized features of the product. For instance, [Gaming Laptop] tag for products with high performance on display effect and game processing; or [Specialized for Girls] tag for laptops which are fancy, light-weighted and easy-to-use. The recommendation function will choose products for target clients based on the filters and tags. 

3. Design a deal submission function for sales representatives. Use elegant user interfaces and workflow to simplify the process of submission. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency. 

### [User C] 
Post/Position: 
Marketing Executive

IT literacy: 
Limited knowledge about IT; Capable of using web applications 

Frequency of using the software: 
Daily

Purpose of using the software: 

1. Analyze sales performances 
2. Update product list 
3. Manage product promotions.

Situation of using the software: 

1. Marketing executives need to analyse the sales performances, and combine the analysis with their observations about the marketing trends to come up with new marketing decisions for the future business growth of the company. 

2. When there is a need to discard some products due to bad sales performance or vanishing market demands, marketing executives need to remove the product from the 'laptop library'. Similarly, when they make a decision to introduce new products based on marketing analysis, they need to add the target laptop into the library as well. 

3. Sometimes the sales for some products do not perform well. Launching a promotion for these products can stimulate the sales, which is the job of marketing executives. 

Describe what user expects.

1. Easy access to up-to-date sales performances reports
    
    The marketing analysis would be very difficult to proceed if marketing executives do not have an easy access to the updated sales performances report whenever they want. The access to sales report will become a bottleneck to restrict marketing executives' job.

2. Convenient and simple operations for updating product list

3. Launch promotions and apply them to list of products conveniently and error-freely
    
    Apply promotions to a list of target products manually is repetitive and tedious. It is also very easy to miss out some products which are supposed to apply promotions, or to introduce some confusions if the marketing executives mistakenly apply multiple promotions to the same product. Marketing executives need a more systematic, efficient way to manage these promotions.

Your proposal to solve the object

1. Authorize the access to sales reports to all marketing executive roles. When marketing executives logs into the system with their own account, they have the sales report sections displayed by default. 

2. Design a function specifically for product management. Use elegant user interfaces and workflow to simplify the process of adding / removing products. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency.

3. Build promotion functionality which can apply to selected list of products. The items in a list can be selected by specifying models, brands, tags or other customized standards. A validation will be gone through to pick out any product in the list with multiple promotions applied. Users can also set the promotion name, valid period, discount amount etc. 


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