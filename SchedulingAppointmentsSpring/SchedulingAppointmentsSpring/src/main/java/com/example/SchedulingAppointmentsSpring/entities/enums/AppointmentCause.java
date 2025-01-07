package com.example.SchedulingAppointmentsSpring.entities.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum AppointmentCause {
    // Routine check-ups and preventive care
    ROUTINE_CHECKUP("Routine Check-up"),
    ANNUAL_EXAM("Annual Physical Exam"),
    PREVENTIVE_SCREENING("Preventive Health Screenings"),
    IMMUNIZATION("Immunizations and Vaccinations"),
    WELLNESS_EXAM("Well-Woman/Well-Man Exam"),
    PEDIATRIC_CHECKUP("Pediatric Check-up"),
    DENTAL_CLEANING("Dental Cleaning and Exam"),
    VISION_HEARING_TEST("Vision and Hearing Test"),

    // Chronic conditions management
    DIABETES_MANAGEMENT("Diabetes Management"),
    HYPERTENSION_MANAGEMENT("Hypertension Management"),
    ASTHMA_COPD_MANAGEMENT("Asthma or COPD Management"),
    ARTHRITIS_MANAGEMENT("Arthritis Management"),
    HEART_DISEASE("Heart Disease Management"),
    THYROID_CONDITION("Thyroid Condition Treatment"),
    CHRONIC_PAIN("Chronic Pain Management"),

    // Acute illnesses or symptoms
    COLD_FLU("Cold, Flu, or Respiratory Infections"),
    FEVER("Fever or Chills"),
    SORE_THROAT("Sore Throat or Cough"),
    DIGESTIVE_ISSUES("Digestive Issues (Diarrhea, Constipation)"),
    UTI("Urinary Tract Infection (UTI)"),
    SKIN_CONDITIONS("Skin Conditions (Rashes, Infections)"),
    ALLERGIES("Allergies (Seasonal, Food, etc.)"),

    // Mental health concerns
    ANXIETY_DEPRESSION("Anxiety, Depression, or Stress"),
    SLEEP_DISORDERS("Sleep Disorders (Insomnia, Sleep Apnea)"),
    MOOD_DISORDERS("Mood Disorders or Panic Attacks"),
    COUNSELING_THERAPY("Counseling or Therapy"),
    ADDICTION_SUPPORT("Addiction or Substance Abuse Support"),

    // Injury or trauma
    SPORTS_INJURY("Sports Injury"),
    BROKEN_BONES("Broken Bones or Fractures"),
    SPRAINS("Sprains, Strains, and Soft Tissue Injuries"),
    HEAD_INJURY("Head Injury (Concussion)"),
    BACK_NECK_INJURY("Back, Neck, or Spinal Injury"),

    // Specialist referrals
    CARDIOLOGY("Cardiology (Heart-Related Concerns)"),
    ENDOCRINOLOGY("Endocrinology (Hormonal or Metabolic Disorders)"),
    NEUROLOGY("Neurology (Nervous System Issues)"),
    ORTHOPEDICS("Orthopedics (Bone and Joint Problems)"),
    DERMATOLOGY("Dermatology (Skin Conditions)"),
    GASTROENTEROLOGY("Gastroenterology (Digestive Issues)"),
    RHEUMATOLOGY("Rheumatology (Autoimmune Disorders)"),
    PSYCHIATRY("Psychiatry or Psychology (Mental Health)"),
    OB_GYN("Obstetrics/Gynecology (Reproductive Health)"),
    UROLOGY("Urology (Urinary and Male Reproductive Health)"),

    // Preventive health and lifestyle adjustments
    WEIGHT_MANAGEMENT("Weight Management and Nutrition Counseling"),
    SMOKING_CESSATION("Smoking Cessation Support"),
    FITNESS_PLANS("Fitness and Exercise Plans"),
    STRESS_MANAGEMENT("Stress Management Techniques"),
    SKIN_CANCER_SCREENING("Skin Cancer Screening or Mole Checks"),

    // Medication management
    PRESCRIPTION_REFILL("Prescription Refill or Adjustments"),
    NEW_MEDICATION("New Medication Evaluation"),
    PAIN_MANAGEMENT("Pain Management Therapy"),
    MEDICATION_SIDE_EFFECTS("Side Effect Management or Concerns"),
    MEDICATION_REVIEW("Medication Interactions or Reviews"),

    // Post-surgery or post-treatment follow-up
    POST_SURGERY_FOLLOWUP("Post-Surgery or Post-Treatment Follow-up"),
    PHYSICAL_THERAPY("Physical Therapy or Rehabilitation"),
    CANCER_TREATMENT_FOLLOWUP("Cancer Treatment Follow-up"),
    POSTPARTUM_CHECKUP("Postpartum Check-up"),

    // Pregnancy or fertility concerns
    PRECONCEPTION_COUNSELING("Preconception Counseling"),
    PRENATAL_VISITS("Prenatal Visits and Monitoring"),
    FERTILITY_TREATMENT("Fertility Treatments or Consultations"),

    // Age-related health concerns
    MENOPAUSE_MANAGEMENT("Menopause or Perimenopause Management"),
    OSTEOPOROSIS_SCREENING("Osteoporosis Screening"),
    GERIATRIC_CARE("Geriatric Care Assessments"),
    COGNITIVE_DECLINE("Cognitive Decline or Dementia Evaluation"),
    VISION_HEARING_IMPAIRMENT("Vision or Hearing Impairments"),

    // Emergency or urgent care
    CHEST_PAIN("Unexplained Chest Pain"),
    SHORTNESS_OF_BREATH("Shortness of Breath"),
    SEVERE_HEADACHES("Severe Headaches or Migraines"),
    SUDDEN_VISION_CHANGE("Sudden Vision Changes or Loss"),
    SERIOUS_INJURY("Serious Injuries (Cuts, Fractures, etc.)"),

    // Health maintenance for specific populations
    PEDIATRIC_CARE("Pediatric Care (Growth and Development)"),
    ELDERLY_CARE("Elderly Care (Age-Related Health Issues)"),
    LGBTQ_HEALTH("LGBTQ+ Health Screenings or Support"),
    TRAVEL_HEALTH("Travel Health Consultation");

    private final String description;

    AppointmentCause(String description) {
        this.description = description;
    }
}
