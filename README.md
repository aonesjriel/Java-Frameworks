<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

    mainscreen.html; line 14 ->Changed the title of page to "Reverb City"
    mainscreen.html; line 19 ->Changed h1 tag to display name of store ("Reverb City Music Store")




Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.


D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

    about.html; created about.html
    about.html; -> Created html template for about.html
    about.html; line 13 -> Created title for webpage "About"
    about.html; line 17 -> Created h1 tag "About Us"
    about.html; line 19; -> Created generic about us content for the webpage
    AboutPageController.java; Created controller for about page
    AboutPageController.java; line 6 -> added controller annotation
    AboutPageController.java; line 9 -> added getMapping annotation
    mainscreen.html; line 20 -> added anchor tag to hold about us page link
    about.html; line 18 -> added anchor tag to hold link back to mainscreen.html


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

    BootStrapData.java; line 62 -> Created outsourced part "pickup"
    BootStrapData.java; line 71 -> Saved part in outsourcedPartRepository
    BootStrapData.java; line 60 -> created condition to only display parts when count equals 0; so the items aren't duplicated in repo
    BootStrapData.java; line 74-88->Created outsourcedParts "strings" and pick" and saved into the database
    BootStrapData.java; line 91-106 -> Created inhouseParts "fretboard" and "customBridge" and saved into the database
    BootStrapData.java; line 108-118 -> Created products "electricGuitar", "acousticGuitar", "drumKit", "bassGuitar", and "microphone" and saved into the database
    application.properties; line 6 -> Updated version of database so nothing is duplicated


Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

    mainscreen.html; line 50 -> Creasted buy now button for parts
    mainscreen.html; line 87 -> created buy now button for products
    Failure.html -> created to indicate if purchase was failed
    Success.html -> created to indicate if purchase was a success
    AddProductController.java; line 180-> created getmapping for buy now button--created condition to display failure or success depending on inventory
    AddPartController.java; line 70-> created getmapping for buy now button--created condition to display failure or success depending on inventory


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
    Part.java; line 33-> created minInv value
    Part.java; line 36-> created maxInv value
    Part.java; line 96-111-> created accessor and mutator methods for min and max inv
    InventoryValidator.java-> created class for inv validation
    ValidInventory.java-> created annotaion to enfore valid inventory
    Part.java; line 23-> added validator for inventory in class file
    Part.java; line 4-> imported valid inventory validator
    OutsourcedPartForm.html; line 25-> added field in form for minInventory
    OutsourcedPartForm.html; line 27-> added field in form for maxInventory
    OutsourcedPartForm.html; line 32-38-> created error message for invalid inventory entries
    InhousePartForm.html; line 26-29-> created min and max inventory fields for the form
    Mainscreen.html; line 39-40-> created min and max inventory in table
    Mainscreen.html; line 49-50-> created text box for min and max inventory
    BootStrapData.java; line 68-69-> set values for min and max inventory
    BootStrapData.java; line 80-81-> set values for min and max inventory
    BootStrapData.java; line 90-91-> set values for min and max inventory
    BootStrapData.java; line 102-103-> set values for min and max inventory
    BootStrapData.java; line 112-113-> set values for min and max inventory
    application.properties; line 6-> updated database version
    InhousePartForm.html; line 32-38-> created error message for invalid inventory
    ProductInventoryValidator; created class for max and min valid inventory entries
    ProductValidInventory.java; created annotation to enforce valid inventory
    Product.java; line 24-> added Inventory validator
    Product.java; line 33-37-> created min and max Inv
    Product.java; line 97-111-> created accessor and mutator methods for max and min inv
    Product.java; line 4-> imported valid inventory validator
    productForm.html; line 24-27-> added min and max inventory fields 
    productForm.html; line 30-36-> created error message to display if inventories are invalid
    mainscreen.html; line 80-81-> added min inv and max inv to table
    mainscreen.html; line 90-91-> added min and max inv columns
    BootStrapData.java; line 120-121-> set values for min and max inventory
    BootStrapData.java; line 124-125-> set values for min and max inventory
    BootStrapData.java; line 128-129-> set values for min and max inventory
    BootStrapData.java; line 132-133-> set values for min and max inventory
    BootStrapData.java; line 136-137-> set values for min and max inventory






H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.
    Completed the first two bullets in part G
    EnufPartsValidator.java; line 37-39-> added condition that checks min part inventory to make sure no products can be updated with invalid part amount
    ValidEnufParts,java; line 20 -> altered default error message
    application.properties; line 6-> updated database




I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

    PartTest.java; line 94-110-> created getMinInv() test and getMaxInv() test to check max and min values of parts


J.  Remove the class files for any unused validators in order to clean your code.
    removed DeletePartsValidator.java
    changed version of database in application.properties


K.  Demonstrate professional communication in the content and presentation of your submission.