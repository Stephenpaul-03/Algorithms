#Basic Count Sort without Duplicate Management

def counting_sort(arr):
    if not arr:
        return []

    max_val = max(arr)
    count = [0] * (max_val + 1)

    # Count each number
    for num in arr:
        count[num] += 1

    # Build the sorted array
    sorted_arr = []
    for num, freq in enumerate(count):
        sorted_arr.extend([num] * freq)

    return sorted_arr

#Count Sort with Duplicate Management and Order Preserving
def stable_counting_sort(arr):
    if not arr:
        return []

    max_val = max(arr)
    count = [0] * (max_val + 1)

    # Count frequencies
    for num in arr:
        count[num] += 1

    # Transform count[i] to hold actual positions
    for i in range(1, len(count)):
        count[i] += count[i - 1]

    output = [0] * len(arr)

    # Build the output array backwards for stability
    for i in reversed(range(len(arr))):
        num = arr[i]
        count[num] -= 1
        output[count[num]] = num

    return output


# Example usage
arr = [4, 2, 2, 8, 3, 3, 1]
print(stable_counting_sort(arr))  # Output: [1, 2, 2, 3, 3, 4, 8]
