Live Order Board - interview exercise for Giraffe / Zoo Risk Platform Developer # 121299 - Wenxuan Zhou 18/01/2019

The task is implemented in Java 8 via a "minimalist" TDD approach, please refer to OrderBoardServiceTest. 

I have made assumptions based on the example provided in problem description. when in doubt I tried to stick the simple case (following the "write the minimum amount of code to pass the test" TDD principle), with potential enhancements discussed as follows:

1. Consider 3rd Party library apart from Junit out of scope, keep code/number of classes to minimal. 
2. Could consider turn this into a SpringBoot project for WEB access(RESTful API), out of scope for this task
3. Consider Concurrency/Multi-threading out of scope, could consider use Collections.synchronizedList() / ConcurrentHashMap for future enhancement
4. Assume price per kg to be Integer and represent quantity as Double for simplicity, in reality if precision is of concern we could consider use BigDecimal (see https://stackoverflow.com/questions/3413448/double-vs-bigdecimal) 
5. Keep the Order class to only those 4 fields stated in the description, which means we do not have a unique identifier for order (like orderId which will almost always present in reality), hence we define the removeOrder() operation to remove the first occurrence of the order which matches all 4 fields, should the same user placed exactly the same order more than once.
6. Remove order will only work on the exact match, if no exact match the method will have no effect. We will not be able to cancel part of the order, line 46 in OrderBoardServiceTest is a sample invalid call.
7. Output summary in a plain String format, since the project will be packaged and shipped as a library, which the output could be handled in the main project.
8. We assume valid order input and exception handling is out of scope




