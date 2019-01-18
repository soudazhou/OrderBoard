Live Order Board - interview exercise for Giraffe / Zoo Risk Platform Developer # 121299 - Wenxuan Zhou 18/01/2019

The task is implemented in Java 8 via a "minimalist" TDD approach, please refer to OrderBoardServiceTest. 

I have made assumptions based on the example provided which I tried to stick the simple case, with potential enhancement to be discussed as follows:

1. Consider 3rd Party library apart from Junit out of scope, keep code/number of classes to minimal
2. Consider Concurrency/Multi-threading out of scope
3. Assume price per kg to be Integer and represent quantity as Double for simplicity, if precision is of concern we could consider use BigDecimal (see https://stackoverflow.com/questions/3413448/double-vs-bigdecimal) 
4. Keep the Order class to only those 4 fields stated in the description, which means we do not have a unique identifier for order (like orderId which will almost always present in reality), hence we define the cancelOrder operation to remove the first occurrence of the order which matches all 4 fields, should the same user placed exactly the same order more than once.
5. Cancel order will only work on the exact match, if no exact match the method will have no effect. We will not be able to cancel part of the order, line 46 in OrderBoardServiceTest is a sample invalid call.
6. Output summary in String format
7. We assume the order input to be valid and exception handling is out of scope




