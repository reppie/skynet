from django.db import models

class DoesItWorkModel(models.Model):
    is_working = models.BooleanField()
    migration_worked = models.BooleanField()
