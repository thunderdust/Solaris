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
    Working in his office, when there are new employees joining the company / employees leaving the company, he is responsible to create user account for the new employee in based on his role and personal information such as name, age, gender, email, contact number and so on. In the case of leaving employees, he is in charge of the deactivation of the user account;
    
    [ Sales Representative]
    
    1) Sell products (laptops) to customers:
    Sales representative can work in his office, or at the appointment with clients. When sales representatives meet clients and try to sell the products to them, they need to demonstrate products to clients, give them suggestions or recommendations about which laptop to purchase, and eventually persuade them to buy the products.
        
    2) Submit sales results (in the application):
    When a deal is completed, sales representatives need to submit the details of the deal (model sold, quantity of purchase, deal price, client name, client contact, deal date, etc) to the system.
    
    [ Marketing Executive ]
    
    1) Management of products:
    Marketing executives work in their offices. When marketing team decide to launch new products, product addition is needed; When marketing team decide to abandon a product, product deletion is required; When there is a promotion/adjustment of certain product, modification is required. In aforementioned cases, he is in charge of adding new products into the system / deleting discarded products / modifying specifications of a product for promotions or adjustments.
    
    2) Promote products:
    When there is a need to promote certain products to increase sales, it's the job of marketing executives. The promotion is conducted by giving discount to laptops involved in this promotion. They need to create promotions, decide the explicit discount amount, and apply the promotion to target products.
    
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
Manage employees and supervise the business development

Situation of using the software: 
1. When new employees enter the company, GM uses the software to create account for him.
2. When employess resign from the company, GM uses the softwar to deactivate their account.
3. When GM wants to check the sales performances of the sales representatives, he can use the accountant functions of the software 

Describe what user expects.
1. Easy-to-use functions for adding / removing employee accounts
2. Reliable and secured database without leaking employee information easily
3. The software delivers comprehensive reflections of sales performances 

Your proposal to solve the object
1. Design a function specifically for user management. Use elegant user interfaces and workflow to simplify the process of adding / removing user accounts. Use input validations and auto-completion where applicable to reduce the chance for errors and increase the efficiency. 
2. Use MySQL database secured with passwords; design the database schema such that passwords of users are encrypted before saving to the database to increase security level.
3. Apply customized selection criteria to the sales report function to suit different requirements for the sales performance supervision: 
   - GM can view the sales performance of individual sales representatives in certain month
   - GM can view the sales performance of certain product model in selected period of time
   - GM can view the total amount of sales in selected period of time
   - GM can view the monthly sales growth rate for specified products


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