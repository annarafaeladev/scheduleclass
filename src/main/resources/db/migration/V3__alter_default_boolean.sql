
ALTER TABLE instructor
    ALTER COLUMN is_owner SET DEFAULT false;

ALTER TABLE student
    ALTER COLUMN active SET DEFAULT false;

ALTER TABLE class_schedule
    ALTER COLUMN active SET DEFAULT false;

ALTER TABLE booking
    ALTER COLUMN canceled SET DEFAULT false;