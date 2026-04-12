import csv
import uuid
import os

def generate_uuids(num_uuids):
    return [str(uuid.uuid4()) for _ in range(num_uuids)]

def create_csv(filename, num_rows, num_fields):
    with open(filename, 'w', newline='') as csvfile:
        writer = csv.writer(csvfile)
        for _ in range(num_rows):
            row = generate_uuids(num_fields)
            writer.writerow(row)

if __name__ == "__main__":

    # Get current script directory (testdata folder)
    base_dir = os.path.dirname(os.path.abspath(__file__))

    # Output file inside testdata folder
    filename = os.path.join(base_dir, "uuids.csv")

    num_rows = 200
    num_fields = 4

    create_csv(filename, num_rows, num_fields)

    print(f"CSV file '{filename}' with {num_rows} rows and {num_fields} fields each created successfully.")