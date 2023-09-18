<h2><a href="https://leetcode.com/problems/destroy-sequential-targets/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2453. Destroy Sequential Targets</a></h2><h3>Medium</h3><hr><div><p>You are given a <strong>0-indexed</strong> array <code>nums</code> consisting of positive integers, representing targets on a number line. You are also given an integer <code>space</code>.</p>

<p>You have a machine which can destroy targets. <strong>Seeding</strong> the machine with some <code>nums[i]</code> allows it to destroy all targets with values that can be represented as <code>nums[i] + c * space</code>, where <code>c</code> is any non-negative integer. You want to destroy the <strong>maximum</strong> number of targets in <code>nums</code>.</p>

<p>Return<em> the <strong>minimum value</strong> of </em><code>nums[i]</code><em> you can seed the machine with to destroy the maximum number of targets.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,7,8,1,1,5], space = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> If we seed the machine with nums[3], then we destroy all targets equal to 1,3,5,7,9,... 
In this case, we would destroy 5 total targets (all except for nums[2]). 
It is impossible to destroy more than 5 targets, so we return nums[3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,5,2,4,6], space = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> Seeding the machine with nums[0], or nums[3] destroys 3 targets. 
It is not possible to destroy more than 3 targets.
Since nums[0] is the minimal integer that can destroy 3 targets, we return 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [6,2,5], space = 100
<strong>Output:</strong> 2
<strong>Explanation:</strong> Whatever initial seed we select, we can only destroy 1 target. The minimal seed is nums[1].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= space &lt;=&nbsp;10<sup>9</sup></code></li>
</ul>
</div>