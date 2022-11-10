# fibabanka-springboot-bootcamp-project
@author berklimoncu

**<h1>Project Hiearchy</h1>
<h2>This repository includes 3 different kinds of projects: inventory, shopping & commerce </h2>
<h3 style=₺> 1. inventory runs on port 8081</h3>
<h3> 2. shopping runs on port 8082</h3>
<h3> 3. commerce runs on port 8080</h3>

<h2> Steps to run </h2>

<h3> 1. Make sure that you have JDK 11 </h3>
<h3> 2. Make sure that you have two different databases whose names are 'inventory' and 'shopping' and also DB configurations looks like below images 2.1 and 2.2</h3>

><h4>2.1 Database Configuration for inventory(8081) project:
</h4>

![image](https://user-images.githubusercontent.com/76854271/201101128-d5ca3eaf-6958-4004-8347-52e5003a55cc.png)


><h4>2.2 Database Configuration for shopping(8082) project:
</h4>

![image](https://user-images.githubusercontent.com/76854271/201099289-83461ff0-bace-4988-8cb6-14b5686b8612.png) 


<h3> 3. After the configuration and database creation done, you have to run project seperately in the following order </h3>

><h4> 3.1 Run inventory project </h4>
![InventoryApplication](https://user-images.githubusercontent.com/76854271/201102296-97d81e5c-33a4-444d-a8e0-83b314dd2211.jpg)


><h4> 3.2 Run shopping project </h4>
![ShoppingApplication](https://user-images.githubusercontent.com/76854271/201102781-18e8c803-c534-42d1-8d16-ee74b5912171.jpg)

><h4> 3.3 Run commerce project </h4>
![CommerceApplication](https://user-images.githubusercontent.com/76854271/201103119-fd99caf5-a095-455a-8578-ab252df7c93f.jpg)

 
 <h3> 4.Now you are ready to go :) </h3>
 
 <h1> Sample API Requests </h1>
 
 <h2> You can import PostMan Collection from at the end of the this readme file </h2>
 
 
 ><h2> 1. Inventory </h2>
 >1.1 Add Category
 <img width="834" alt="Pasted Graphic 1" src="https://user-images.githubusercontent.com/76854271/201105603-357d2ea2-ee96-4792-849a-82ba7acca5e1.png">

>1.2 Add Product
>>1.2.1 If there is no Category with given categoryId
<img width="743" alt="Pasted Graphic 13" src="https://user-images.githubusercontent.com/76854271/201105813-1ed0db6d-761b-484b-8e7f-8a7b07d8249d.png">

>>1.2.2 Add Product Successfull Response
<img width="680" alt="Pasted Graphic 2" src="https://user-images.githubusercontent.com/76854271/201106194-2367172a-ec7f-4278-9a16-e59ac04006db.png">

>1.3 Get Categories
<img width="666" alt="Pasted Graphic 3" src="https://user-images.githubusercontent.com/76854271/201106261-352c522e-2d2a-441f-a877-13790df6bde1.png">

>1.4 Get Products by categoryId
>>1.4.1 Invalid Id
<img width="743" alt="Pasted Graphic 14" src="https://user-images.githubusercontent.com/76854271/201106361-f13949aa-b688-4c52-b768-d7a356140bb7.png">

>>1.4.2 Get Products Successfull Response
<img width="739" alt="Pasted Graphic 4" src="https://user-images.githubusercontent.com/76854271/201106555-4b992307-c4fd-4880-8ba1-823629b3b5fa.png">

>1.5 Get Product by productId

>>1.5.1 Invalid Id
<img width="742" alt="Pasted Graphic 16" src="https://user-images.githubusercontent.com/76854271/201106754-796d4060-adf8-4ee6-bf2c-cc0f4e9e1118.png">

>>1.5.2 If there is no Category with given productId
<img width="743" alt="Pasted Graphic 17" src="https://user-images.githubusercontent.com/76854271/201106864-2fae8544-80aa-4f25-99c7-a4210c09c29f.png">

>>1.5.3 Get Product by productId Succesfull
<img width="742" alt="Pasted Graphic 5" src="https://user-images.githubusercontent.com/76854271/201106922-7b759b78-1e49-4f4c-bb68-de454852962a.png">

 
 
 ><h2> 2. Shopping </h2>
 
 >2.1 Create Cart with Customer Name as Header
 ![Add Cart with Header](https://user-images.githubusercontent.com/76854271/201107178-1fbeee17-83a2-46ea-af95-306dce3cb7ac.jpg)
<img width="737" alt="Pasted Graphic 6" src="https://user-images.githubusercontent.com/76854271/201107188-886131d8-2e1f-4c11-a4f5-6ef5028db687.png">

>2.2 Add CartProduct with cartId & productId

>2.2.1 If there is no Category with given cartId
<img width="740" alt="Pasted Graphic 18" src="https://user-images.githubusercontent.com/76854271/201107367-78f26956-814b-44b7-b503-9f4db90b888f.png">

>2.2.2 Add CartProduct with cartId & productId Successful
<img width="734" alt="Pasted Graphic 7" src="https://user-images.githubusercontent.com/76854271/201107477-7de5423d-4405-4224-bc7a-160bc2b1fa72.png">


>2.3 Remove CartProduct with cartId & productId
>2.3.1 If there is no Cart with given cartId || productId
<img width="730" alt="Pasted Graphic 19" src="https://user-images.githubusercontent.com/76854271/201107755-1fb3d073-4e6b-4a44-8bde-bd0f509bb761.png">

>2.3.2 Remove CartProduct with cartId & productId Successful
<img width="743" alt="Pasted Graphic 8" src="https://user-images.githubusercontent.com/76854271/201107796-64ecd2ef-2d75-4f4f-8c70-0ec30f5927de.png">

>2.4 Checkout with CartId
>2.4.1 If there is no Cart with given cartId
<img width="739" alt="Pasted Graphic 20" src="https://user-images.githubusercontent.com/76854271/201107886-6b7fae87-7321-4c34-b03b-6c7524d70a5c.png">

>2.4.2 Checkout with CartId Successful
<img width="741" alt="Pasted Graphic 9" src="https://user-images.githubusercontent.com/76854271/201107968-2e82bef9-37a7-48b5-afeb-d2a8c95e198f.png">


>2.5 Find Cart with cartId

>2.5.1 Invalid ID
<img width="748" alt="Pasted Graphic 11" src="https://user-images.githubusercontent.com/76854271/201108182-1dd570e5-922c-4242-8808-36a19d4aa783.png">

>2.5.2 If there is no Cart with given cartId
<img width="737" alt="Pasted Graphic 21" src="https://user-images.githubusercontent.com/76854271/201108245-2117de96-58b9-451c-8086-4fae25d2dc51.png">

>2.5.3 Find Cart with cartId Successful
<img width="749" alt="Pasted Graphic 10" src="https://user-images.githubusercontent.com/76854271/201108344-355cb5d2-16d1-4d7c-86f1-13cf1af6024f.png">

 ><h2> 3. Commerce </h2>



