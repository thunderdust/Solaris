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

    Three different groups of user get involved in this business: Managers, sales representatives, and marketing executives.
     
    [Managers] 
    General manager of the business and the employees in the company.

    [Sales Managers] 
    Formed by managers of sales representatives from sales department. 
    
    [Sales Representatives] 
    Formed by the employees of sales team in the company. This is the major user group, who produce the most of the profits for the business.

    [After-sale Service Agent]
    This group of employees are responsible for dealing with the after-sale services. 

    [Sales Accountants]
    Sales accountants need to prepare the sales reports for managers and marketing executives. 


**3. Describe each of their work flow: WHAT are they responsible for? WHEN, WHERE and WHAT do they work?**

    Each of the 3 types of users involved in this business plays their own roles and collaborates with each other to deliver a better sales results for the company. 
    
    [ General Managers ]
    1) Management of human resources:
    Working in his office, when there are new joiners, he is responsible to create the account and the profile for the new employee.
    When there are leavers, he is responsible for deactivating the account for the leaver.
    Manager is also responsible for assessing and evaluating employees, and deciding the salary and position adjustments.
     
    2) Business decision making 
    Managers need to make decisions on purchases, inventory, sales and so on based on his judgement and sales manager's suggestions.

    [ Sales Managers ]
    1) Market analysis and strategy making
    It's the responsibility of them to analyze the market situations, including the laptop purchase price changes, comparisons of laptop vendors, the market demand trends and so on. They also need to combine the analysis result with the current sales performances, and make suggestions for future strategies.
    
    2) Product promotions:
    When the sales for some products perform poorly or there is a demand to increase sales for certain products, it's the job of marketing executives to conduct product promotions.
    
    [ Sales Representative]
    1) Sell laptops (to customers):
    Sales representative can work in his office, or at the appointment with clients. When sales representatives meet clients, their job is to sell laptops to clients by demonstrating products to clients, giving them suggestions or recommendations about which laptop to purchase, and eventually persuading them to buy the products.

    2) Confirm orders with customers and submit orders:
    After customers agree to buy the product, sales representatives need to confirm the order with them, and submit the signed orders back to the company.
        
    3) Submit sales results:
    When a deal with customers is finished, sales representatives need to submit the details of the deal (deal number, deal date, laptop model, quantity of purchase, deal price, client name, client contact information, etc) to the accounting department.

    [After-sale Service Agent] 
    1) Handle after-sale service requests at the service center of the company.
      
    [ Sales Accountant ]
    1) Sum up sales amount 
    Accountants have to do summation of sales amount weekly, monthly, quarterly or yearly according to specific situations. 
     
    2) Calculate profit
    It is their job to compute how much profit the company has made during a period of time as well. 
    
    3) Produce sales report 
    Upon the request of manager or market analyzers, accountant has to produce various kinds of sales reports tailored for different purposes. 


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

1. *Manage employees*
2. *Supervise and evaluate sales performances*						

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

    1) Look up for sales representative A's record page from the sales records;
    2) (With the help of accountant) Add up his sales amount;
    3) Record down A's sales summary;
    4) Repeat step 1-3 for any sales representatives that GM wants to check, say B, C, D, E, F, ... etc.
    5) Compare and evaluate the performances of sales representatives


Describe what user expects.

1. *Add / remove employee accounts easily*
    
   Creating an account is a tedious and repetitive work. The workflow to accomplish this task is very similar from time to time except for the differences in personal information. For account deletion, manager has to look up for the related records in multiple linked record tables ( When delete an account from employee list, his sales record table needs to be deactivated as well ). Therefore user wants to simplify these two tasks and make them less tedious. 
    
2. *Reliable and secured management of employee information* 
    
    The management of employee information can be challenging in terms of information security. How to keep all the sensitive information without leaking it to outside of company is a serious problem for the manager.  Traditional way of keeping everything on paper is not secured enough: the information can be damaged or leaked out easily. Hence managers expect a more reliable, secured method to manage the employee information. 
    
3. *Effectively evaluate the most updated sales performances*

    By the traditional way supervising sales performances is inefficient. Every time when the manager wants to check some sales representative's performance, he (or the accountant) has to look up for this person's sales records from a large number of rows, and then asks the accountant to add up all sales amount of this person before he can actually sees the sales performance for a single person. The worse part is that the calculated sales result of this person is not real-time, meaning the result does not include changes happen after start of the calculation (time spend can be very long due to slow computation). Hence the manager would be very glad to have a faster, more effective, and more updated sales performances evaluation.
    
Your proposal to solve the object

1. Implement a function in the Solaris application specifically for employee management. Use elegant user interfaces and workflow to simplify the process of adding / removing user accounts:  
- Identity number will be auto-generated and saved 
- Account creation date is current date by default 
- Use input validations where applicable to reduce the chance for errors. For example, check the email format automatically to prevent invalid email address; or check if the employee name is an empty input to prevent absence of information 
- Provide auto-completion where applicable to speed up the process of creating account. For example, use selection menu for the "job title" input field with options of manager, sales, marketing etc. And once an option is selected, the system will fill in the basic salary automatically (assuming for each type of job the basic salary is pre-defined, and if not manager can always amend it manually). 

2. Information of each employee will be stored in the same schema as a data entity with encryption, from where the read / addition / modification / deletion is executed. This mechanism will protect the information from leaking out. 
Each employee will be assigned an account for the use of ONLY himself which is protected by a unique password. This will ensure the privacy of each employee is protected, and make sure they can only access data that belongs to themselves.

3. Utilize report function of Solaris to meet manager's needs for sales performance evaluation: Individual sales person can be targeted easily with a single operation of search (by name / company identity number). His sales amount will be calculated dynamically and shown upon the search request. Manager can view the performance of this person in a second. This is much faster than manually looking up for his records and sum them up, and therefore ensures the up-to-date sales performance evaluation as well. 


### [User B] 

Post/Position: 
Sales Managers

IT literacy: 
Limited knowledge about IT; Capable of using web applications 

Frequency of using the software: 
Daily

Purpose of using the software: 

1. Analyze market 
2. Manage product promotions.

Situation of using the software: 

1. Marketing executives need to analyse the sales performances, and combine the analysis with their observations about the marketing trends to come up with new marketing decisions for the future business growth of the company. 

2. When there is a need to discard some products due to bad sales performance or vanishing market demands, marketing executives need to remove the product from the 'laptop library'. Similarly, when they make a decision to introduce new products based on marketing analysis, they need to add the target laptop into the library as well. 

3. Sometimes the sales for some products do not perform well. Launching a promotion for these products can stimulate the sales, which is the job of marketing executives. 

Describe what user expects.

1. Easy access to up-to-date sales reports
    
    For marketing executives, the marketing analysis would be very difficult to proceed if they do not have an easy access to the updated sales performances report whenever they want. Hence the accessibility to sales report becomes a bottleneck to restrict marketing executives' job, which is exactly what happens in a typical cooperation between marketing executives and report producers. They wish to have an easier, faster way to obtain the updated sales conditions when they need to do marketing analysis. 

2. Convenient and simple operations for updating product list
    
    After a marketing decision related to adjustments of product is made, marketing executives need to update the product list. When a product needs to be aborted, the challenge they would face is that they have to take tremendous time and effort to look for it from the large list of all kinds of products. After that, they still need to take extra time to make a back-up information for this removed product in case the company will re-import this product in the future. When a new product is going to be imported into the list, the process of checking for redundant items, filling in all the information of this new product, and linking it to all other related data (e.g. tags, promotions etc) is definitely a pain for them as well. Therefore, they would like to have a more convenient, efficient tool to help them accomplish these tasks. 

3. Launch promotions and apply them to list of products conveniently and error-freely
    
    Apply promotions to a list of target products manually is repetitive and tedious. It is also very easy to miss out some products which are supposed to apply promotions, or to introduce some confusions if the marketing executives mistakenly apply multiple promotions to the same product. Marketing executives need a more systematic, efficient way to manage these promotions.

Your proposal to solve the object

1. Authorize the access to sales reports to all marketing executive roles. When marketing executives logs into the system with their own account, they have the sales report sections displayed by default. 

2. Design a function specifically for product management. Use elegant user interfaces and workflow to simplify the process of adding / removing products. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency.

3. Build promotion functionality which can apply to selected list of products. The items in a list can be selected by specifying models, brands, tags or other customized standards. A validation will be gone through to pick out any product in the list with multiple promotions applied. Users can also set the promotion name, valid period, discount amount etc. 


### [User C] 

Post/Position:  
Sales Representative

IT literacy: 
Basic IT knowledge; Able to use web applications

Frequency of using the software: 
Daily

Purpose of using the software: 

1. *Present products, make suggestions and sell products to customers*
2. *Report sales results to the company*

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

1. *An easy-to-operate but powerful demonstration to showcase products to customers as detailed as possible*
    
    It is impossible for sales to bring all different models of laptops for the customers to choose. Hence presentation of laptops on a computer screen must be persuasive and convincing enough. The demonstration should be able to provide information of products as detailed as possible, yet not too complicated to operate or to watch. 

2. *Being able to efficiently make recommendations based on various requirements of clients*

    Clients can have all kinds of different requirements about their ideal laptops. At the same time, their only have limited patience. Hence it is hard for sales representatives to quickly find out the product(s) which match the customer needs. If they fail to do so, the business opportunity might be wasted. 

3. *Conveniently submit deals results* 
    
    Due to the nature of the work, sales representatives spend lots of their time working with the clients and often being out of the office. In a traditional manner, when one deal is done, they need to record the details down and go back to the office and report to whoever is managing the deal results. This is very troublesome and inefficient for both the sales and the staff who manages the deal results (Even if sales can report the results via a phone call or an email it still takes much extra time for the staff who manages sale results to process and record all the information). So it is very necessary to have a new way to submit deal results without so much trouble.

Your proposal to solve the object

1. Create a comprehensive and fully-detailed 'laptop library' to store information of all models of products that the company holds. Design an elegant, user-friendly interface in the application for the showcase to enhance visual effects. Use images of laptops with the actual dimensions to make it more vivid. Quantify the performance and battery life of laptops to give customers a more accurate and straightforward evaluation. 
   
2. Design powerful search functions which filters products by user's preferences such as brand, size, weight, screen size, price range, battery performance, hardware specifications etc. There can be more than one search criteria. On top of that, assign each laptop with one or a few tags which describes the specialized features of the product. For instance, [Gaming Laptop] tag for products with high performance on display effect and game processing; or [Specialized for Girls] tag for laptops which are fancy, light-weighted and easy-to-use. The recommendation function will choose products for target clients based on the filters and tags. If customers do not have any requirements / expectations / preferences about the laptop, the system can still make recommendations based on customer's features such as gender, age, salary, occupation etc.

3. Design a deal submission function for sales representatives. Use elegant user interfaces and workflow to simplify the process of submission. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency. 



### [User C] 
Post/Position:  
After-sales Service Agent 

IT literacy: 
Medium IT knowledge; Understand basic knowledge about laptop software and hardware  

Frequency of using the software: 
Daily

Purpose of using the software: 

1. *Deal with after-sale service requests of laptop replacement and repair from clients*

Situation of using the software: 

1. When a customer calls service center and asks for replacement / repair of the laptop he purchased, after-sales service agents need to handle the request. He serves as a mediator between customer and the company to provide customers with satisfying after-sales services.  

Describe what user expects.

1. *Conveniently check customer's purchase records and get crucial information like purchased model, purchased date, warranty length etc in time.*
    
    Looking for particular customer's purchase information such as purchased model, purchased date, warranty length from hundreds of different records manually is way to slow for a customer to wait for. The quality of after-sales service will be largely affected by the responding time. Maintenance of all such information is also difficult and troublesome when there is no systematic management for it. Such after-sales services contribute an essential part to the sales performance as customers value it a lot when it comes to laptop purchase. Poor services might bring the company a damaged reputation. Hence after-sales agents need a faster and more convenient way to do this task indeed. 

2. *Easy to track the status of maintenance services* 
    
     After validating after-sales service requests from customers and transferred them to technical staff, the next task on after-sales service agent's shoulders is to keep track of the progress of the service.  However this is not easy. There can be a lot of requests going on at the same time, which come from different clients, involve different products, ask for different services (replacement, return, repair, etc). The whole maintenance service will be extremely messy without a sophisticated management of all these different requests. So the service agents expect a much more easier way to track progress of all different requests, so they can follow up the cases accordingly with order.  

Your proposal to solve the object

1. Use our application Solaris to maintain purchase records and use the after-sales function of Solaris to help the services. The agent can conveniently obtain customer's record within a second by searching it with customer's order number, or name, or contact number.  And the purchased date, warranty length, whether warranty has expired (with a status of YES or NO) will be automatically displayed when the record is been found. Agents can save huge amount of time finding the customer's purchase information, checking with customer about the warranty status, and validating it. It is also so easy to process this service request after the call as it is still within the same application system.  

2. Use the after-sales function of Solaris to do the management of different service requests. When agents receive a new call from a customer, they will simply create a new request in the system for the customer. This request is automatically associated with the customer's order. As the progress of this maintenance request changes, its status in the system will be updated accordingly (e.g. status might vary from 'Pending' to 'Queuing', 'In progress', 'Almost Finished' or 'Ready'). Agents can follow up the status any time they wish with simply a search by the request index or by the name of the customer and update the progress to the customer promptly. They can also check the requests categorized by the status. For example, they can find out which requests are still queuing, then tell the customers to wait; or they can look for 'Almost Finished' requests and inform customers that they can receive the results in a short time. 
  


### [User E] 
Post/Position:  
Sales Accountants

IT literacy: 
Limited IT knowledge; Able to use accounting software  

Frequency of using the software: 
Daily

Purpose of using the software: 

1. Cost calculation
2. Sales sum up
3. Profit calculation
4. Finance reports production

Situation of using the software: 

1. Sales accountants have to compute the cost for each deal for the calculation of profit 

2. Sales accountants have to sum up sales amount for production of finance and sales reports

3. Sales accountants have to calculate the profits the whole company and each of the sales representatives have made

4. Sales accountants have to combine all the information above to produce reports to reflect the company's business dynamics. 

Describe what user expects.

1. Faster calculations with less errors:
    
The calculations and summaries are very tedious, easy to make mistakes yet hard to find out the errors. Errors on calculations can cause serious loss for the company. Accountants need some assistants to help them deliver their work with faster speed and higher accuracy. 

2. Efficiently generate diverse reports 

The range of finance reports or sales report vary from time to time, accountants have to process some repetitive data over and over again to produce reports for managers or market analyzers. Again, this work is tedious, and has a high risk for errors. A better tool to generate reports efficiently according to the demands is definitely expected from accountants, because it can increase the efficiency largely and avoid most of the calculation errors. 

Your proposal to solve the object

1. Use the accounting function of Solaris to help accelerate calculations. All the data required such as laptop purchased price, sold price, sales amounts are all entered before in linked data storage,  which saves the time of looking up for all the records to get the data. With several simple operations to specify the scope and goal for calculation, Solaris will present the correct results within seconds. 

2. Use the report function of Solaris to generate reports. Accountants just need to set the type and scope of the report, all the rest will be handled by the application. For example, for monthly sales report of each sales representative, the accountant just need to select "sales report" option, specify the time range to be January, choose "sort by employee name", and click "Generate", an accurate, detailed, comprehensive report will be created in a few seconds. Of course, instead of the standard settings for reports, they can also customized the results to be presented in the report. For example, they can set filter criteria so that the sales report only shows performances of employees who joined the company for less than 3 months. 


---
## Chapter 3 - Descriptions of each "Merit"

### [Merit 1] --  Convenient and efficient sales managements

The most valuable merit of the application is that it eases the management for sales activities from several aspects:
 
1. Systematic and secured management for information of sales employees 
2. Attractive, convincing and customized product demonstrations
3. Convenient way to submit finished deal details wherever sales representatives are 

#### [Function 1: Employee account management function]

Support account creation, deactivation, and update.  

**Priority:** High

**Implemented:** N

#### [Function 2: Product list update ]

Add, remove, or modify product information.

**Priority:** Medium

**Implemented:** N


#### [Function 3: Present laptop information ]

Present details of laptops via the user interface. 

**Priority:** Medium

**Implemented:** N


#### [Function 4: Submit deals ]

Submit information of completed deals to the system.

**Priority:** Low

**Implemented:** N



### [Merit 2] -- Effective product promotions

Another unique advantage of the application is that it supports product promotion, which is an effective way to stimulate the sales performance. 

#### [Function 1: Create promotions]

Specify the promotion name, discount percentage / amount, and valid period to create a new promotion.

**Priority:** Medium

**Implemented:** N

#### [Function 2: Apply promotions]

After a promotion is created, it needs to be applied to specific list of products.

**Priority:** Medium

**Implemented:** N


### [Merit 3] -- Accurate product recommendations

Product recommendation plays an important part in sales if the recommendation can accurately meet client's requirements. This application supports accurate product recommendations which can finds the most suitable selection for the customer based on their requirements / expectations / preferences (if they have none of the above, the system can still make recommendations based on customer's features such as gender, age, salary, occupation etc).

#### [Function 1: Search with multiple filters]

Such function is critical for the recommendation feature, because when customers have several requirements, the system has to quickly find out the list of products which are qualified. 

**Priority:** High

**Implemented:** N

#### [Function 2: Assign tags to laptops]

Assign tags that describe the features or merits of a laptop, such as [gaming laptop] or [business laptop] or [ultra notebook], etc. Then tags become a recommendation criteria. 

**Priority:** Low

**Implemented:** N


#### [Function 3: Blur Matching ]

It is almost impossible to find an ideal recommendation that matches all requirements from the customer. As long as the major expectations are met by the recommendation, it can be a good match. Blur matching permits products which do not fully satisfy all criteria to become a recommendation.    

**Priority:** Medium

**Implemented:** N


#### [Function 4: Rank recommendations by suitability ]

Due to the blur matching function, there can be more than one recommendation for each customer. Ranking is required to let the customers know which recommendation is the best option. Intuitively, ranking the results by the degree to which the recommendation matches customer's requirements is the most rational method. 

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