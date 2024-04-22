// Time Complexity : O(n*2^n)
// Space Complexity : O(n*2^n)

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        q = []
        seen = set()
        q.append(s)
        seen.add(s)
        found_valid = False
        while q and not found_valid:
            for _ in range(len(q)):
                curr = q.pop(0)
                if self.isValid(curr):
                    res.append(curr)
                    found_valid = True
                elif not found_valid:
                    for i in range(len(curr)):
                        if curr[i] in '()':  # We only create new strings by removing parentheses
                            baby = curr[:i] + curr[i+1:]
                            if baby not in seen:
                                seen.add(baby)
                                q.append(baby)
        return res

    def isValid(self, s: str) -> bool:
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                if count == 0:
                    return False
                count -= 1
        return count == 0



// Time Complexity : O(V+E)
// Space Complexity : O(V+E)


from collections import deque

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    hashMap = {}
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node == None: return None
        q = deque([node])
        newCopy = self.clone(node)
        while q:
            curr = q.popleft()
            neighb = curr.neighbors
            for n in neighb:
                if n not in self.hashMap:
                    q.append(n)
                nCopy = self.clone(n)
                self.hashMap[curr].neighbors.append(nCopy)
        return newCopy

    def clone(self, node: Optional['Node']):
        if node in self.hashMap: return self.hashMap[node]
        newNode = Node(node.val)
        self.hashMap[node] = newNode
        return newNode
        

        
