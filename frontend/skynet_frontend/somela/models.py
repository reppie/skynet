from django.db import models

class DoesItWorkModel(models.Model):
    is_working = models.BooleanField()
    is_still_working = models.BooleanField()