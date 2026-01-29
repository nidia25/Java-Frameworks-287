<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

 Part C: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
 (mainscreen.html)
1. Line 14- Changed title to my new shop name
2. Line 19- Entered my new shop name
3. Line 21-Entered my product name
4. Line 53- Entered part name
D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
Created "about.html"
5. Line 1-12 copied html template from mainscreen.html to have match
6. Line 14- Added title "About"
7. Line 17- Added h1 "About Us"
8. Line 18- Added About us in paragraph form
9. Line 21- Added link to return to the Main page
Created "AboutController"
10. Line 8-16 Created controller for about page
Mainscreen.html
11. Line 20- Added button to access about page
E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and 
five products in your sample inventory and should not overwrite existing data in the database.
(BootStrapData.java)
12. Line 73-74: Added Hash for sampleProducts and sampleParts
13. Line 77-87: Added sample products to database
14. Line 89: Added sample system.out line for products
15. Line 92-135: Added Inhouseparts 
16. 138-143: If statement was added for products and parts
F. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
    •  The “Buy Now” button must be next to the buttons that update and delete products.
    • The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
    •  Display a message that indicates the success or failure of a purchase.
(Mainscreen.html)
17. Line 84: Added "buy now" button
(AddProductController.java)
18. Line 120-132: Added "buy Product" Controller with success/unsuccesful messages as well as if statements for inventory.
(Confirmationbuynow.html)
19. Created confirmationbuynow.html and entered success message for purchase on line 9-11, and mapped link back to main screen.
(unsuccessfulbuynow.html)
20. Created unsuccessfulbuynow.html and entered failure message for when inventory is == 0, and mapped link back to main screen.
21. Added Test product on localhost.8080 to test inventory ==0.
 G.  Modify the parts to track maximum and minimum inventory by doing the following:
    •  Add additional fields to the part entity for maximum and minimum inventory.
    •  Modify the sample inventory to include the maximum and minimum fields.
    •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
    •  Rename the file the persistent storage is saved to.
    •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
    (Part.java)
22. Line 31-34 Added Min and Max inventory ID's
23. Lines 92-103 Added getter and setter for Min and Max inventory
24. Line 23: Added ValidInventory
25. (mainscreen.html)
26. Line 38-39 & 48-49 Added Min and Max to table
(BootStrapData.java)
27. 97-98 & 105-106 & 113-114 & 121-122 & 129-130 Added Min and Max inventory to parts
(application.properties)
28. Line 6 Renamed  file persistent storage 
InhousePartForm.html)
29. Line 26-30 Added text inputs for Min and Max
30. Line 16,18,21,24 Added name to each text input
Created (InventoryValidator.java & ValidInventory.java)
(ValidInventory.java)
31. Line 16 & 19: Entered class validator 
32. Line 20: Changed string message
(InventoryValidator.java)
33. Line 19 & 25: Changed interface 
34. Line 34-41 Created code with error to make sure inventory was between min and max
H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
       •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
       •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
       •  Display error messages when adding and updating parts if the inventory is greater than the maximum.
(AddInHousePartController.java)
35. Line 43-54 Added if statement to create error for inventory less than min or more than max inv.
(AddOutsourcePartController.java)
36. Line 44-55 Added if statement to create error for inventory less than min or more than max inv.
    I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
(PartTest.Java)
37. Line 159-190 Set up getter and setter for min and max
38. (EDIT LINES 38-39 INVENTORYVALIDATOR.JAVA)
39. Added new messages for min and max inventory
    (EDIT LINES 37-46 ENUFPARTSVALIDATOR.JAVA)
40. Edited error message for min and max treshold 
J.  Remove the class files for any unused validators in order to clean your code.
Deleted unused validator file name--DeletePartValidator.java
Corrections
    (AddInHousePartController.java)
38. Deleted lines between 43-52 to fix error
    (PartTest)
39. Worked with 129-134 made changes to fix error
EDITS
    (OutsourcedPartForm.html)
40. Line 25-33 Added Min and Max fields
41. Line 17,19,22 Added Names to inputs for headers
    (ValidInventory.java)
42. Line 21: Changed string message for error
    (ProductForm.html)
43. Line 17,19,22 Added headers to products
44. Line 39-40 Added Min and Max to table
45. Line 49-50 Added min and max header to associate parts
46. Line 63-64 Added min and max to table
47. Line 73-74 Added remove part min and max header
48. Line 81-82 Added Link to Main screen
    (AddInhousePartController.java)
49. Line 41-66 Added paramaters for min and max
    (EnufPartsValidator.java)
50. Line 39-43 Added error message min and max parameters
Edited(EnufPartsValidator.java)
51. Lines 37-46 Edited if statements min and max to fix whitelabel error