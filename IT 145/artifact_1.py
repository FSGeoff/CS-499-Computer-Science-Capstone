def get_positive_integer(prompt):
    """
    Prompts the user for a positive integer input.
    Continues to prompt until a valid positive integer is entered.
    """
    while True:
        try:
            value = int(input(prompt))
            if value < 0:
                raise ValueError("Please enter a positive number.")
            return value
        except ValueError as e:
            print(e)  # Print the error message and prompt again

def get_positive_float(prompt):
    """
    Prompts the user for a positive float input.
    Continues to prompt until a valid positive float is entered.
    """
    while True:
        try:
            value = float(input(prompt))
            if value < 0:
                raise ValueError("Please enter a positive number.")
            return value
        except ValueError as e:
            print(e)  # Print the error message and prompt again

def calculate_checkout_amount():
    """
    Main function to calculate the checkout amount for pet boarding.
    It handles user input, applies pricing logic based on animal type,
    and outputs the total amount due.
    """
    print("Welcome to the Pet Boarding Checkout System")

    # Get the type of animal from the user
    animal_type = input("Enter the type of animal (cat or dog): ").strip().lower()

    # Logic for calculating the checkout amount based on animal type
    if animal_type == "cat":
        # For cats, get the number of days stayed and calculate the amount due
        days_stay = get_positive_integer("Enter the number of days the cat stayed: ")
        amount_due = days_stay * 18.00  # Cat rate is $18.00 per day
    elif animal_type == "dog":
        # For dogs, get the number of days stayed and the dog's weight
        days_stay = get_positive_integer("Enter the number of days the dog stayed: ")
        weight = get_positive_float("Enter the weight of the dog in pounds: ")

        # Determine the rate based on the dog's weight
        if weight < 20:
            amount_due = days_stay * 24.00  # Dog rate for < 20 lbs is $24.00 per day
            grooming_fee = input("Was there a grooming fee? (yes/no): ").strip().lower()
            if grooming_fee == "yes":
                amount_due += 24.00  # Add grooming fee
        elif 20 <= weight < 30:
            amount_due = days_stay * 26.00  # Dog rate for 20-29 lbs is $26.00 per day
            grooming_fee = input("Was there a grooming fee? (yes/no): ").strip().lower()
            if grooming_fee == "yes":
                amount_due += 24.00  # Add grooming fee
        else:  # weight >= 30
            amount_due = days_stay * 30.00  # Dog rate for >= 30 lbs is $30.00 per day
            grooming_fee = input("Was there a grooming fee? (yes/no): ").strip().lower()
            if grooming_fee == "yes":
                amount_due += 24.00  # Add grooming fee
    else:
        # Handle invalid animal type input
        print("Invalid animal type. Please enter 'cat' or 'dog'.")
        return

    # Output the total amount due
    print(f"The total amount due for the {animal_type} is: ${amount_due:.2f}")

if __name__ == "__main__":
    # Run the checkout calculation when the script is executed
    calculate_checkout_amount()
