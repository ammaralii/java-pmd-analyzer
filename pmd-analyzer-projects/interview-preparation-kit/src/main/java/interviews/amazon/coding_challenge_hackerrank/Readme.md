### Question 1
You are shopping on Amazon.com for some bags of rice. Each listing displays the number of grains of rice that the bag 
contains. You want to buy a perfect set of rice bags from the entire search results list, riceBags. A perfect set of 
rice bags, perfect, is defined as:

- The set contains at least two bags of rice.

- When the rice bags in the set perfect are sorted in increasing order by grain count, it satisfies the 
condition perfect[i]. <br/> perfect[i]= perfect[i+1] for all 1 <= i < n. Here n is the size of the set and perfect[i] is the number of rice grains in bag i.

Find the largest possible set perfect and return an integer, the size of that set. If no such set is possible, then return -1. It is guaranteed that all elements in riceBags are distinct.

**Example**

Let the bags of rice available on Amazon have grain counts [3, 9, 4, 2, 16]. The following are the perfect sets.

- Set perfect = [3, 9]. The size of this set is 2.
- Set perfect=[4,2]. The size of this set is 2.  
- Set perfect = [4, 16]. The size of this set is 2.
- Set perfect = [4, 2, 16]. The size of this set is 3.

The size of the largest set is 3. The image below illustrates the correct ordering of the purchased rice bags by grains of rice.

**Function Description**

Complete the function maxSetSize in the editor below.

maxSetSize has the following parameter: int riceBags[n]: the list of bags of rice by rice grain count

### Question 2
Amazon Fresh is a new grocery store designed from the ground up to offer a seamless grocery shopping experience to consumers. As part of a stock clearance exercise at the store, given many piles of fresh products, follow the rules given below to stack the products in an orderly manner.
- There are a total of n piles of products.
- The number of products in each pile is represented by the array numProducts. 
- Select any subarray from the array numProducts and pick up products from that subarray such that the number of products you pick from the i<sup>th</sup> pile is strictly less than the number of products you pick from the (i+1)<sup>th</sup> pile for all indices of the subarray.

Find the maximum number of products that can be picked.

**Example**

The numbers of products in each pile are numProducts = [7, 4, 5, 2, 6, 5].

These are some ways strictly increasing subarrays can be chosen (1 -based index):
- Choose subarray from indices (1, 3) and pick products [3, 4, 5] respectively from each index, which is 12 products. Note that we are forced to
pick only 3 products from index 1 as the maximum number of products we can pick from index 2 is 4 and we need to make sure it is greater
than the number of products picked from index 1.
- Choose subarray from indices (3, 6) and pick products [1, 2.4, 5] respectively from each index, which is 12 products. Similar to the above case,
we are forced to pick only 1 product from index 3 as the number of products at index 4 is only 2.
- Choose subarray from indices (3, 5) and pick products [1, 2, 6] respectively from each index, which is 9 products.
- Choose subarray from indices (1, 1) and pick all the 7 products.

![img.png](resources/question2_example.png)

The maximum number of product is 12

**Function Description**

Complete the function findMaxProducts in the editor below.

findMaxProducts has the following parameter: int products[n]: the list of products of numbers of products in each pile

### Question 3
Amazon Shopping recently launched a new item whose daily customer ratings for n days is represented by the array ratings. They monitor these ratings to identify products that are not performing well. Find the number of groups that can be formed consisting of 1 or more consecutive days such that the rating continuously decreases over the days.

The rating is consecutively decreasing if it has the form: r, 1-1, r - 2... and so on, where r is the rating on the first day of the group being considered. Two groups are considered different if they contain the ratings of different consecutive days.

**Example**

ratings = [4, 3, 5, 4, 3]

There are 9 periods in which the rating consecutively decreases.

**5 one day periods:** [4], [3], [5], [4], [3]

**3 two day periods:** [4, 3], [5,4], [4, 3]

**1 three-day period:** [5, 4, 3]

These can be visualized in the figure shown below.

![img.png](resources/question3_example.png)

**Tests Cases Examples:**
```
Input:
{2,1,3}

Return:
4
```

```
Input:
{4,3,5,4,3}

Return:
9
```

### Question 4
Give you a list servers. Their processing power is given as a array of integer, and boot power as a array of integer.

Write a function to return the max length of sub array which's power consumption is less than or equal to max power limit.

Formula to calculate the power consumption for a subArray is:

<b>Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray</b>

<b>Note:</b> Single server is also a subArray, return 0 if no such subArray can be found.

